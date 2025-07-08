package net.bearster.jojojetzmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.jojojetzmod.entity.custom.ChairChairJetzEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ChairChairJetzModel extends HierarchicalModel<ChairChairJetzEntity> {
    private final ModelPart body;

    public ChairChairJetzModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(34, 49).addBox(-1.0F, 5.0F, 4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 51).addBox(-6.0F, 5.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(50, 50).addBox(4.0F, 5.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(42, 50).addBox(-1.0F, 5.0F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 37).addBox(1.0F, 4.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 41).addBox(-4.0F, 4.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 45).addBox(-1.0F, 4.0F, -4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 49).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(26, 49).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition seat = body.addOrReplaceChild("seat", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(28, 15).addBox(3.0F, -4.0F, -4.0F, 3.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(28, 26).addBox(-6.0F, -4.0F, -4.0F, 3.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create().texOffs(0, 30).addBox(4.0F, -9.0F, -4.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(24, 37).addBox(-6.0F, -9.0F, -4.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back = body.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 15).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 3).addBox(3.0F, -20.0F, -6.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 9).addBox(-7.0F, -20.0F, -6.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(-3.0F, -17.0F, -6.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 51).addBox(-1.0F, -20.0F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(54, 15).addBox(-7.0F, -16.0F, -6.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 54).addBox(6.0F, -16.0F, -6.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 0).addBox(-6.0F, -21.0F, -6.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 42).addBox(-5.0F, -22.0F, -6.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 45).addBox(-4.0F, -23.0F, -6.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(ChairChairJetzEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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
