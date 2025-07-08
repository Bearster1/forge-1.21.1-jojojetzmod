package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.custom.GooseEntity;
import net.bearster.jojojetzmod.entity.custom.JoJoLinkEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JoJoLinkRenderer extends MobRenderer<JoJoLinkEntity, JoJoLinkModel> {

    public JoJoLinkRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JoJoLinkModel(pContext.bakeLayer(ModModelLayers.JOJO_LINK)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(JoJoLinkEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "textures/entity/jojo_link/jojo_link.png");
    }

    @Override
    public void render(JoJoLinkEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
