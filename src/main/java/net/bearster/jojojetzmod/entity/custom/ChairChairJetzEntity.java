package net.bearster.jojojetzmod.entity.custom;

import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class ChairChairJetzEntity extends AbstractHorse {

    public ChairChairJetzEntity(EntityType<? extends AbstractHorse> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH, 5D)
                .add(Attributes.MOVEMENT_SPEED, -3)
                .add(Attributes.ATTACK_DAMAGE, 10f)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.JUMP_STRENGTH, 0.55f);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    // RIDEABLE


    @Override
    public boolean canUseSlot(EquipmentSlot pSlot) {
        return true;
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        boolean flag = !this.isBaby() && this.isTamed() && pPlayer.isSecondaryUseActive();
        if (!this.isVehicle() && !flag) {
            ItemStack itemstack = pPlayer.getItemInHand(pHand);
            if (!itemstack.isEmpty()) {
                if (this.isFood(itemstack)) {
                    return this.fedFood(pPlayer, itemstack);
                }

                if (!this.isTamed()) {
                    this.makeMad();
                    return InteractionResult.sidedSuccess(this.level().isClientSide);
                }
            }

            return super.mobInteract(pPlayer, pHand);
        } else if (pPlayer.isSecondaryUseActive() && pPlayer.getMainHandItem().isEmpty()) {
            this.remove(RemovalReason.DISCARDED);
            pPlayer.setItemInHand(pHand, new ItemStack(ModItems.CHAIRCHAIRJETZ.get()));
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
        return super.getPassengerAttachmentPoint(entity, dimensions, partialTick)
                .add(new Vec3(0.00, -1.4 * (double)partialTick, 0.0 * (double)partialTick)
                        .yRot(-this.getYRot() * (float) (Math.PI / 180.0)));
    }

    @Override
    public boolean isSaddled() {
        return true;
    }

    @Override
    public boolean isTamed() {
        return true;
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pBlock) {

    }

    @Override
    public void openCustomInventoryScreen(Player pPlayer) {

    }

    @Override
    public @Nullable SoundEvent getAmbientStandSound() {
        return null;
    }

    @Override
    protected void executeRidersJump(float pPlayerJumpPendingScale, Vec3 pTravelVector) {

    }

    @Override
    public boolean canJump() {
        return false;
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        var event = net.minecraftforge.event.ForgeEventFactory.onLivingFall(this, pFallDistance, pMultiplier);
        if (event.isCanceled()) return false;
        pFallDistance = event.getDistance();
        pMultiplier = event.getDamageMultiplier();

        int i = this.calculateFallDamage(pFallDistance, pMultiplier);
        if (i <= 0) {
            return false;
        } else {
            this.hurt(pSource, (float)i);
            if (this.isVehicle()) {
                for (Entity entity : this.getIndirectPassengers()) {
                    entity.hurt(pSource, (float)i);
                }
            }

            this.playBlockFallSound();
            return true;
        }
    }

    @Override
    protected void registerGoals() {
        this.addBehaviourGoals();
    }

    @Override
    protected void addBehaviourGoals() {

    }

    @Override
    public void knockback(double pStrength, double pX, double pZ) {

    }


}
