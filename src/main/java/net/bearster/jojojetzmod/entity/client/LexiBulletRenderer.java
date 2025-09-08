package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.custom.LexiBulletEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * Lexi Bullet Renderer
 */
public class LexiBulletRenderer extends EntityRenderer<LexiBulletEntity> {
    private LexiBulletModel model;

    /** Constructs a new Lexi Bullet Renderer
     * @param pContext Entity Renderer Provider Context
     */
    public LexiBulletRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new LexiBulletModel(pContext.bakeLayer(ModModelLayers.LEXI_BULLET));
    }

    @Override
    public void render(@NotNull LexiBulletEntity pEntity,
                       float pEntityYaw,
                       float pPartialTick,
                       PoseStack pPoseStack,
                       @NotNull MultiBufferSource pBufferSource,
                       int pPackedLight) {
        pPoseStack.pushPose();

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
                pBufferSource, model.renderType(getTextureLocation(pEntity)), false, false);
        model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBufferSource, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(LexiBulletEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "textures/entity/jojo_pikmin/jojo_pikmin.png");
    }
}