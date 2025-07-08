package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.datagen.registry.ModRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = JoJoJetzMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(), new ModLanguageProvider(packOutput));

        event.getGenerator().addProvider(event.includeClient(), new ModSoundDefinitionsProvider(packOutput, existingFileHelper));

        generator.addProvider(true, new ModRegistryProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModBiomesTagsProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModPaintingVariantTagsProvider(
                packOutput, new ModRegistryProvider(packOutput, event.getLookupProvider()).getRegistryProvider(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModCatVariantTagsProvider(
                packOutput, new ModRegistryProvider(packOutput, event.getLookupProvider()).getRegistryProvider(), existingFileHelper));

        generator.addProvider(true, new ModAdvancementProvider(packOutput, lookupProvider, existingFileHelper));
    }

}
