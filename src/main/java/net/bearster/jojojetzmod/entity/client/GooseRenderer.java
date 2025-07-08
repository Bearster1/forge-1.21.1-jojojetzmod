package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.custom.FireTruckEntity;
import net.bearster.jojojetzmod.entity.custom.FirefighterEntity;
import net.bearster.jojojetzmod.entity.custom.GooseEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GooseRenderer extends MobRenderer<GooseEntity, GooseModel> {

    public GooseRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GooseModel(pContext.bakeLayer(ModModelLayers.GOOSE)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(GooseEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "textures/entity/goose/goose.png");
    }

    @Override
    public void render(GooseEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
