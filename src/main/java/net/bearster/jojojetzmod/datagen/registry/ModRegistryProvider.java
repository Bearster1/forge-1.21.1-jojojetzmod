package net.bearster.jojojetzmod.datagen.registry;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.datagen.ModSoundDefinitionsProvider;
import net.bearster.jojojetzmod.worldgen.ModBiomeModifiers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModRegistryProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TEMPLATE_POOL, ModTemplatePools::bootstrap)
            .add(Registries.STRUCTURE, ModStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, ModStructureSets::bootstrap)
            .add(Registries.JUKEBOX_SONG, ModSoundDefinitionsProvider::bootstrap)
            .add(Registries.PAINTING_VARIANT, ModPaintingVariants::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModRegistryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(JoJoJetzMod.MOD_ID));
    }
}
