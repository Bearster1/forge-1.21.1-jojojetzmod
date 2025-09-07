package net.bearster.jojojetzmod.item.custom;

import net.bearster.jojojetzmod.item.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class LexiGunItem extends ProjectileWeaponItem {

    private LexiMagItem _magazine;

    public LexiGunItem(Item.Properties pProperties) {
        super(pProperties);
        _magazine = new LexiMagItem(pProperties);
        _magazine.Load(20);
    }

    @Override
    @NotNull
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (itemStack -> itemStack.getItem() == ModItems.LEXI_BULLET.get());
    }

    @Override
    public int getDefaultProjectileRange() {
        return 0;
    }

    @Override
    protected void shootProjectile(@NotNull LivingEntity pShooter, @NotNull Projectile pProjectile, int pIndex, float pVelocity, float pInaccuracy, float pAngle, @Nullable LivingEntity pTarget) {
        _magazine.Spend();
        pProjectile.shootFromRotation(pShooter, pShooter.getXRot(), pShooter.getYRot() + pAngle, 0.0F, pVelocity, pInaccuracy);
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.NONE;
    }
}