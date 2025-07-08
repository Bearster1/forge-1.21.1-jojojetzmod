package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.jojojetzmod.entity.client.animation.GooseAnimations;
import net.bearster.jojojetzmod.entity.client.animation.JoJoLinkAnimations;
import net.bearster.jojojetzmod.entity.custom.GooseEntity;
import net.bearster.jojojetzmod.entity.custom.JoJoLinkEntity;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class JoJoLinkModel extends HierarchicalModel<JoJoLinkEntity> {

    private final ModelPart body;
    private final ModelPart head;

    public JoJoLinkModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-2.0F, 24.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LL = legs.addOrReplaceChild("LL", CubeListBuilder.create().texOffs(8, 35).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -5.0F, 0.0F));

        PartDefinition RL = legs.addOrReplaceChild("RL", CubeListBuilder.create().texOffs(0, 35).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 0.0F));

        PartDefinition RA = arms.addOrReplaceChild("RA", CubeListBuilder.create().texOffs(10, 31).addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -13.0F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition shield = RA.addOrReplaceChild("shield", CubeListBuilder.create().texOffs(4, 42).addBox(-0.5F, -3.0F, -3.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(42, 6).addBox(-0.5F, 2.0F, -3.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 36).addBox(-0.5F, -4.0F, -4.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 36).addBox(-0.5F, -3.0F, -1.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 36).addBox(-1.5F, -3.5F, -4.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 30).addBox(-2.5F, -3.0F, -4.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 36).addBox(0.5F, -3.5F, -4.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 37).addBox(1.5F, -3.0F, -4.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.48F));

        PartDefinition LA = arms.addOrReplaceChild("LA", CubeListBuilder.create().texOffs(24, 32).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -13.0F, 0.0F, 0.5236F, 0.0F, 0.48F));

        PartDefinition sword = LA.addOrReplaceChild("sword", CubeListBuilder.create().texOffs(16, 35).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 19).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 42).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 9).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(15, 50).addBox(-3.5F, -6.0F, -4.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -15.0F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(37, 52).addBox(-4.5F, -1.0F, -1.0F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 44).addBox(-4.5F, -1.0F, 3.0F, 9.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 23).addBox(3.5F, 0.0F, -1.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-4.5F, 0.0F, -1.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(10, 26).addBox(-3.0F, 0.0F, 6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 23).addBox(-2.5F, 0.5F, 7.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 27).addBox(-2.0F, 1.0F, 8.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 19).addBox(-1.5F, 1.5F, 9.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 37).addBox(-4.0F, -0.5F, 4.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -15.0F, -2.0F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(JoJoLinkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(JoJoLinkAnimations.JOJO_LINK_WALKING_ANIMATION, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(entity.idleAnimationState, JoJoLinkAnimations.JOJO_LINK_IDLE_ANIMATION, ageInTicks, 1f);


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
