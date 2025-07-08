package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.datagen.loot.ModBlockLootTables;
import net.bearster.jojojetzmod.datagen.loot.ModEntityLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future) {
        return new LootTableProvider(packOutput, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                        new LootTableProvider.SubProviderEntry(ModEntityLootTables::new, LootContextParamSets.ENTITY)
                ), future);
    }
}
