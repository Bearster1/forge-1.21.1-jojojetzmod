package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.jojojetzmod.entity.client.animation.GooseAnimations;
import net.bearster.jojojetzmod.entity.client.animation.OldManAnimations;
import net.bearster.jojojetzmod.entity.custom.FirefighterEntity;
import net.bearster.jojojetzmod.entity.custom.GooseEntity;
import net.bearster.jojojetzmod.entity.custom.OldManEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class OldManModel extends HierarchicalModel<OldManEntity>  {
    private final ModelPart body;
    private final ModelPart head;

    public OldManModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-6.0F, 24.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(0, 2).addBox(1.0F, -1.0F, -1.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(2.0F, -3.0F, -1.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 6).addBox(-4.0F, -4.0F, -0.5F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 6).addBox(-3.0F, -5.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -11.0F, -0.5F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 4).addBox(1.0F, -11.0F, -1.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -10.0F, -1.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(2.0F, -9.0F, -1.0F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(3.0F, -6.0F, -1.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition L = arms.addOrReplaceChild("L", CubeListBuilder.create().texOffs(22, 2).addBox(1.5F, 1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 15).addBox(-0.5F, 6.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 8).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -9.0F, -0.5F));

        PartDefinition R = arms.addOrReplaceChild("R", CubeListBuilder.create().texOffs(4, 22).addBox(-0.5F, 6.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 18).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-2.5F, 1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, -9.0F, -0.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(OldManEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(OldManAnimations.OLD_MAN_WALKING_ANIMATION, limbSwing, limbSwingAmount, 1f, 2.5f);
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
