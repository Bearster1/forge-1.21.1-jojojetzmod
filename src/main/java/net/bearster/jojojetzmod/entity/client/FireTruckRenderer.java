package net.bearster.jojojetzmod.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.custom.FireTruckEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FireTruckRenderer extends MobRenderer<FireTruckEntity, FireTruckModel<FireTruckEntity>> {

    public FireTruckRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FireTruckModel(pContext.bakeLayer(ModModelLayers.FIRE_TRUCK)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(FireTruckEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "textures/entity/fire_truck/fire_truck.png");
    }

    @Override
    public void render(FireTruckEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(1f, 1f, 1f);
        } else {
            pPoseStack.scale(2.5f, 2.5f ,2.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
