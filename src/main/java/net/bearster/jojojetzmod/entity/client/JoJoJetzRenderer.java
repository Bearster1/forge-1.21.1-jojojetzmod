package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.custom.FirefighterEntity;
import net.bearster.jojojetzmod.entity.custom.JoJoJetzEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JoJoJetzRenderer extends MobRenderer<JoJoJetzEntity, JoJoJetzModel> {

    public JoJoJetzRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JoJoJetzModel(pContext.bakeLayer(ModModelLayers.JOJOJETZ)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(JoJoJetzEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "textures/entity/jojojetz/jojojetz.png");
    }

    @Override
    public void render(JoJoJetzEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1.5f, 1.5f, 1.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
