package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.custom.GooseEntity;
import net.bearster.jojojetzmod.entity.custom.JoJoPikminEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JoJoPikminRenderer extends MobRenderer<JoJoPikminEntity, JoJoPikminModel> {

    public JoJoPikminRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JoJoPikminModel(pContext.bakeLayer(ModModelLayers.JOJO_PIKMIN)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(JoJoPikminEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "textures/entity/jojo_pikmin/jojo_pikmin.png");
    }

    @Override
    public void render(JoJoPikminEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}