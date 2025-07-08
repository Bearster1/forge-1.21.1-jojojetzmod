package net.bearster.jojojetzmod.datagen.registry;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.util.ModTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public interface ModStructures {
    ResourceKey<Structure> FIRE_TRUCK = create("fire_truck");
    ResourceKey<Structure> MUSIC_MACHINE = create("music_machine");
    ResourceKey<Structure> FIRE_STATION = create("fire_station");

    private static ResourceKey<Structure> create(String name) {
        return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name));
    }

    static void bootstrap(BootstrapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(FIRE_TRUCK, new JigsawStructure(
                new Structure.StructureSettings(
                        biomes.getOrThrow(ModTags.Biomes.HAS_FIRE_TRUCK),
                        Map.of(
                                MobCategory.MONSTER, new StructureSpawnOverride(
                                        StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                        WeightedRandomList.create(new MobSpawnSettings.SpawnerData(ModEntities.FIREFIGHTER.get(), 1 ,1, 1))
                                )
                        ),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                templatePools.getOrThrow(ModTemplatePools.FIRE_TRUCK),
                2,
                ConstantHeight.ZERO,
                false,
                Heightmap.Types.WORLD_SURFACE_WG
        ));

        context.register(MUSIC_MACHINE, new JigsawStructure(
                new Structure.StructureSettings(
                        biomes.getOrThrow(ModTags.Biomes.HAS_MUSIC_MACHINE),
                        Map.of(

                        ),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                templatePools.getOrThrow(ModTemplatePools.MUSIC_MACHINE),
                2,
                ConstantHeight.ZERO,
                false,
                Heightmap.Types.WORLD_SURFACE_WG
        ));

        context.register(FIRE_STATION, new JigsawStructure(
                new Structure.StructureSettings(
                        biomes.getOrThrow(ModTags.Biomes.HAS_FIRE_STATION),
                        Map.of(

                        ),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                templatePools.getOrThrow(ModTemplatePools.FIRE_STATION),
                2,
                ConstantHeight.ZERO,
                false,
                Heightmap.Types.WORLD_SURFACE_WG
        ));
    }
}
