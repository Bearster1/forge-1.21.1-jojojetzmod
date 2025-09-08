package net.bearster.jojojetzmod.entity.custom;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

/**
 * A Lexi Bullet Entity
 */
public class LexiBulletEntity extends Projectile {
    private float rotation = 0.0F;

    /** Constructs a new Base Bullet Entity that is cast out of a Gun
     * @param pEntityType The Bullet Entity
     * @param pLevel The current World
     */
    public LexiBulletEntity(EntityType<? extends LexiBulletEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    /**
     * @return Rendering Rotation
     */
    public float getRenderingRotation() {
        rotation += 0.5f;
        if (360.0F <= rotation) {
            rotation = 0.0F;
        }
        return rotation;
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(damageSources().thrown(this, getOwner()), 4.0F);

        if (!level().isClientSide) {
            level().broadcastEntityEvent(this, (byte)3);
            discard();
        }
    }

    @Override
    public void shoot(double pX, double pY, double pZ, float pVelocity, float pInaccuracy) {
        super.shoot(pX, pY, pZ, pVelocity, pInaccuracy);
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.discard();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder pBuilder) {

    }
}
