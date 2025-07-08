package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.jojojetzmod.entity.client.animation.FirefighterAnimations;
import net.bearster.jojojetzmod.entity.client.animation.JoJoJetzAnimations;
import net.bearster.jojojetzmod.entity.custom.FirefighterEntity;
import net.bearster.jojojetzmod.entity.custom.JoJoJetzEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class JoJoJetzModel extends HierarchicalModel<JoJoJetzEntity> {

    private final ModelPart body;
    private final ModelPart head;

    public JoJoJetzModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-2.0F, 18.0F, 0.0F));

        PartDefinition RL = legs.addOrReplaceChild("RL", CubeListBuilder.create().texOffs(24, 8).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LL = legs.addOrReplaceChild("LL", CubeListBuilder.create().texOffs(24, 16).addBox(3.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(3.0F, 2.0F, 0.0F));

        PartDefinition RA = arms.addOrReplaceChild("RA", CubeListBuilder.create(), PartPose.offset(-7.0F, 1.0F, 0.0F));

        PartDefinition cube_r1 = RA.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 4).addBox(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition LA = arms.addOrReplaceChild("LA", CubeListBuilder.create(), PartPose.offset(1.0F, 1.0F, 0.0F));

        PartDefinition cube_r2 = LA.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.48F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(JoJoJetzEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(JoJoJetzAnimations.JOJOJETZ_WALKING_ANIMATION, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(entity.idleAnimationState, JoJoJetzAnimations.JOJOJETZ_IDLE_ANIMATION, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45f);

        this.head.xRot = headYaw * ((float)Math.PI / 180f);
        this.head.yRot = headPitch * ((float)Math.PI / 180f);

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
