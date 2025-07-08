package net.bearster.jojojetzmod.datagen.registry;

import com.mojang.datafixers.util.Pair;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;

public interface ModTemplatePools {
    ResourceKey<StructureTemplatePool> FIRE_TRUCK = create("fire_truck");
    ResourceKey<StructureTemplatePool> MUSIC_MACHINE = create("music_machine");
    ResourceKey<StructureTemplatePool> FIRE_STATION = create("fire_station");

    private static ResourceKey<StructureTemplatePool> create(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name));
    }

    static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(FIRE_TRUCK, new StructureTemplatePool(
                templatePools.getOrThrow(Pools.EMPTY),
                List.of(
                        Pair.of(StructurePoolElement.single("jojojetzmod:fire_truck"), 1)
                ),
                StructureTemplatePool.Projection.RIGID
        ));

        context.register(MUSIC_MACHINE, new StructureTemplatePool(
                templatePools.getOrThrow(Pools.EMPTY),
                List.of(
                        Pair.of(StructurePoolElement.single("jojojetzmod:music_machine"), 1)
                ),
                StructureTemplatePool.Projection.RIGID
        ));

        context.register(FIRE_STATION, new StructureTemplatePool(
                templatePools.getOrThrow(Pools.EMPTY),
                List.of(
                        Pair.of(StructurePoolElement.single("jojojetzmod:fire_station"), 1)
                ),
                StructureTemplatePool.Projection.RIGID
        ));
    }
}
