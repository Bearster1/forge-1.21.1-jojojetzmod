package net.bearster.jojojetzmod.event;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.entity.client.*;
import net.bearster.jojojetzmod.entity.custom.*;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = JoJoJetzMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CHAIRCHAIRJETZ, ChairChairJetzModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FIREFIGHTER, FirefighterModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FIRE_TRUCK, FireTruckModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GOOSE, GooseModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.OLD_MAN, OldManModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.JOJO_LINK, JoJoLinkModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.JOJO_PIKMIN, JoJoPikminModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.JOJOJETZ, JoJoJetzModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CHAIRCHAIRJETZ.get(), ChairChairJetzEntity.createAttributes().build());
        event.put(ModEntities.FIREFIGHTER.get(), FirefighterEntity.createAttributes().build());
        event.put(ModEntities.FIRE_TRUCK.get(), FireTruckEntity.createAttributes().build());
        event.put(ModEntities.GOOSE.get(), GooseEntity.createAttributes().build());
        event.put(ModEntities.OLD_MAN.get(), GooseEntity.createAttributes().build());
        event.put(ModEntities.JOJO_LINK.get(), JoJoLinkEntity.createAttributes().build());
        event.put(ModEntities.JOJO_PIKMIN.get(), JoJoPikminEntity.createAttributes().build());
        event.put(ModEntities.JOJOJETZ.get(), JoJoJetzEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.GOOSE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
/*
    @SubscribeEvent
    public static void onFMLCommonSetup(FMLCommonSetupEvent event) {
        ModCriterionTriggers.init();
    }

 */

}
