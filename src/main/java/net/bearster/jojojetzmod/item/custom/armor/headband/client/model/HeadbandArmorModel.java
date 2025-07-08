package net.bearster.jojojetzmod.item.custom.armor.headband.client.model;

import net.bearster.jojojetzmod.item.custom.armor.ArmorModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class HeadbandArmorModel extends ArmorModel {

    public HeadbandArmorModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(0, 34).addBox(-4.5F, -7.0F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition armorLeftArm = partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition armorRightArm = partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition armorLeftLeg = partdefinition.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition armorRightLeg = partdefinition.addOrReplaceChild("armorRightLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition armorLeftBoot = partdefinition.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition armorRightBoot = partdefinition.addOrReplaceChild("armorRightBoot", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}