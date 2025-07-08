package net.bearster.jojojetzmod.item.custom.armor.firefighter.client.model;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.bearster.jojojetzmod.item.custom.armor.ArmorModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class FirefighterArmorModel extends ArmorModel {

	public FirefighterArmorModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(-3, 55).addBox(-4.0F, -12.0F, -5.0F, 8.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(26, 49).addBox(-5.0F, -10.0F, -6.0F, 10.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(8, 3).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition armorLeftArm = partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(5, 26).addBox(-1.0F, -4.0F, -3.0F, 5.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition armorRightArm = partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(5, 26).addBox(-4.0F, -4.0F, -3.0F, 5.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition armorLeftLeg = partdefinition.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create().texOffs(42, 3).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition armorRightLeg = partdefinition.addOrReplaceChild("armorRightLeg", CubeListBuilder.create().texOffs(42, 3).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition armorLeftBoot = partdefinition.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create().texOffs(40, 26).addBox(-2.0F, 9.0F, -3.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition armorRightBoot = partdefinition.addOrReplaceChild("armorRightBoot", CubeListBuilder.create().texOffs(40, 26).addBox(-2.0F, 9.0F, -3.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}