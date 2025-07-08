package net.bearster.jojojetzmod.item.custom.armor;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import net.bearster.jojojetzmod.item.ModArmorMaterials;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class ModArmorItem extends ArmorItem {
    private static final String FULL_SET_ID = "hadFullSet";
    protected int fullSetTick = 0;

    public ModArmorItem(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }


    public boolean equals(ArmorItem item) {
        return this == item || item.getMaterial() == this.getMaterial();
    }



    protected void fullSetTick(ItemStack stack, Level level, LivingEntity living) {}
    protected void initFullSetTick(ItemStack stack, Level level, LivingEntity living) {}
    protected void postFullSetTick(ItemStack stack, Level level, LivingEntity living) {}
    protected void clientFullSetTick(ItemStack stack, Level level, LivingEntity living) {}

    public Multimap<Attribute, AttributeModifier> getAttributeMods(EquipmentSlot slot) {return null;}



    // display / model START

    protected abstract boolean withCustomModel();
    protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) { return null;}

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        if (!withCustomModel()) return;
        consumer.accept(new IClientItemExtensions() {
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
                HumanoidModel<?> armorModel = new HumanoidModel<>(getRenderer(living, stack, slot).makeArmorParts(slot));
                armorModel.crouching = living.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = living.isBaby();
                return armorModel;
            }
        });
    }

    public static ResourceLocation makeCustomTextureLocation(String nameSpace, String id) {
        return ResourceLocation.fromNamespaceAndPath(nameSpace, "textures/models/armor/custom/" + id + ".png");
    }

    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.FIREFIGHTER_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 1, false, false)))
                    .build();


    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if(!level.isClientSide() && hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}