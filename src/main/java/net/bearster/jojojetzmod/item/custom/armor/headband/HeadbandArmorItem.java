package net.bearster.jojojetzmod.item.custom.armor.headband;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.item.custom.armor.ArmorRenderer;
import net.bearster.jojojetzmod.item.custom.armor.ModArmorItem;
import net.bearster.jojojetzmod.item.custom.armor.ArmorModel;
import net.bearster.jojojetzmod.item.custom.armor.headband.client.model.HeadbandArmorModel;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import org.jetbrains.annotations.Nullable;

public class HeadbandArmorItem extends ModArmorItem {


    public HeadbandArmorItem(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public int getColor(ItemStack stack) {
        DyedItemColor color = stack.get(DataComponents.DYED_COLOR);
        return color != null ? color.rgb() : 0xA06540;
    }

    public boolean hasCustomColor(ItemStack stack) {
        return stack.get(DataComponents.DYED_COLOR) != null;
    }

    public void setColor(ItemStack stack, int color) {
        stack.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
    }

    public void clearColor(ItemStack stack) {
        stack.remove(DataComponents.DYED_COLOR);
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
        return new ArmorRenderer<ArmorModel>(HeadbandArmorModel::createBodyLayer, HeadbandArmorModel::new);
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean inner) {
        return makeCustomTextureLocation(JoJoJetzMod.MOD_ID, "headband_armor");
    }
}