package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.jojojetzmod.entity.client.animation.JoJoPikminAnimations;
import net.bearster.jojojetzmod.entity.custom.JoJoPikminEntity;
import net.bearster.jojojetzmod.entity.custom.JoJoPikminProjectileEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class JoJoPikminProjectileModel extends EntityModel<JoJoPikminProjectileEntity> {
    private final ModelPart body;

    public JoJoPikminProjectileModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(-2.5F, 1.5F, -0.5F));

        PartDefinition RA = arms.addOrReplaceChild("RA", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = RA.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 9).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition LA = arms.addOrReplaceChild("LA", CubeListBuilder.create(), PartPose.offset(5.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = LA.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 7).addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(1.0F, 8.0F, 0.0F));

        PartDefinition LL = legs.addOrReplaceChild("LL", CubeListBuilder.create().texOffs(16, 16).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition RL = legs.addOrReplaceChild("RL", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -7.0F, -2.0F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 7.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -4.0F, -2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leaf = head.addOrReplaceChild("leaf", CubeListBuilder.create().texOffs(16, 4).addBox(-2.0F, -6.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 0).addBox(-3.5F, -9.0F, -1.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 11).addBox(-0.5F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.4363F, 0.0F, -0.3054F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(JoJoPikminProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

}
