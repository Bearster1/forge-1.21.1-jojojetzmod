package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.jojojetzmod.entity.client.animation.FirefighterAnimations;
import net.bearster.jojojetzmod.entity.client.animation.GooseAnimations;
import net.bearster.jojojetzmod.entity.custom.FireTruckEntity;
import net.bearster.jojojetzmod.entity.custom.FirefighterEntity;
import net.bearster.jojojetzmod.entity.custom.GooseEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class GooseModel extends HierarchicalModel<GooseEntity> {
    private final ModelPart body;
    private final ModelPart head;

    public GooseModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("torso").getChild("neck").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition R = legs.addOrReplaceChild("R", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 4.0F, -3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(22, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -6.0F, 0.0F));

        PartDefinition L = legs.addOrReplaceChild("L", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 4.0F, -3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(22, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -6.0F, 0.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition tail = torso.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -4.7687F, 5.8119F));

        PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 27).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7687F, 0.1881F, -0.3491F, 0.0F, 0.0F));

        PartDefinition neck = torso.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(22, 18).addBox(-2.0F, -6.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, -5.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 18).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(30, 28).addBox(-0.5F, -2.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(GooseEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(GooseAnimations.GOOSE_WALKING_ANIMATION, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(entity.idleAnimationState, GooseAnimations.GOOSE_IDLE_ANIMATION, ageInTicks, 1f);
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
