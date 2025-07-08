package net.bearster.jojojetzmod.item.custom.armor.fedora.client.model;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.bearster.jojojetzmod.item.custom.armor.ArmorModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class FedoraArmorModel extends ArmorModel {

	public FedoraArmorModel(ModelPart root) {super(root);}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(16, 1).addBox(-6.0F, -9.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(2, 44).addBox(-3.0F, -13.0F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

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