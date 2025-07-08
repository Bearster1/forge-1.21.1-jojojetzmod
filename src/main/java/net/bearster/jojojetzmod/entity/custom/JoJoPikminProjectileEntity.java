package net.bearster.jojojetzmod.entity.custom;

import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;

public class JoJoPikminProjectileEntity extends AbstractArrow {
    private float rotation;
    public Vec2 groundedOffset;


    public JoJoPikminProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public JoJoPikminProjectileEntity(LivingEntity shooter, Level level) {
        super(ModEntities.JOJO_PIKMIN_PROJECTILE.get(), shooter, level, new ItemStack(ModItems.JOJO_PIKMIN.get()), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.JOJO_PIKMIN.get());
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 4);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);

            JoJoPikminEntity pikmin = ModEntities.JOJO_PIKMIN.get().create(this.level());

            if (pikmin != null) {
                pikmin.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);

                pikmin.setPersistentAngerTarget(result.getEntity().getUUID());
                this.level().addFreshEntity(pikmin);
            }
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        JoJoPikminEntity pikmin = ModEntities.JOJO_PIKMIN.get().create(this.level());

        if (pikmin != null) {
            pikmin.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);

            this.level().addFreshEntity(pikmin);
        }
        this.discard();
    }
}
