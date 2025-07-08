package net.bearster.jojojetzmod.datagen.registry;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public interface ModStructureSets {
    ResourceKey<StructureSet> FIRE_TRUCK = create("fire_truck");
    ResourceKey<StructureSet> MUSIC_MACHINE = create("music_machine");
    ResourceKey<StructureSet> FIRE_STATION = create("fire_station");

    static ResourceKey<StructureSet> create(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name));
    }

    static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

        context.register(FIRE_TRUCK, new StructureSet(
                structures.getOrThrow(ModStructures.FIRE_TRUCK),
                new RandomSpreadStructurePlacement(
                        32, 8, RandomSpreadType.LINEAR, 157983457
                ))
        );

        context.register(MUSIC_MACHINE, new StructureSet(
                structures.getOrThrow(ModStructures.MUSIC_MACHINE),
                new RandomSpreadStructurePlacement(
                        32, 8, RandomSpreadType.LINEAR, 167983457
                ))
        );

        context.register(FIRE_STATION, new StructureSet(
                structures.getOrThrow(ModStructures.FIRE_STATION),
                new RandomSpreadStructurePlacement(
                        32, 8, RandomSpreadType.LINEAR, 663963939
                ))
        );
    }
}
