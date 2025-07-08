package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.custom.ChairChairJetzEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ChairChairJetzRenderer extends MobRenderer<ChairChairJetzEntity, ChairChairJetzModel> {


    public ChairChairJetzRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ChairChairJetzModel(pContext.bakeLayer(ModModelLayers.CHAIRCHAIRJETZ)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(ChairChairJetzEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "textures/entity/chairchairjetz/chairchairjetz.png");
    }

    @Override
    public void render(ChairChairJetzEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

}
