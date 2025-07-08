package net.bearster.jojojetzmod.item.custom.armor;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BasicArmorItem extends ModArmorItem {
    private String ID;

    public BasicArmorItem(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties, String ID) {
        super(pMaterial, pType, pProperties);
        this.ID = ID;
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean inner) {
        return makeCustomTextureLocation(JoJoJetzMod.MOD_ID, ID);
    }
}
