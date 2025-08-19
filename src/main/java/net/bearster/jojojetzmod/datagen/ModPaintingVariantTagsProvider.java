package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.datagen.registry.ModPaintingVariants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;


public class ModPaintingVariantTagsProvider extends PaintingVariantTagsProvider {
    public ModPaintingVariantTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, JoJoJetzMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(PaintingVariantTags.PLACEABLE)
                .add(ModPaintingVariants.JOJO_KNIGHT)
                .add(ModPaintingVariants.JJJC_PROPAGANDA)
                .add(ModPaintingVariants.JOJO_BOTW)
                .add(ModPaintingVariants.LEGEND_OF_DAVIE)
                .add(ModPaintingVariants.TASTY_DISCO)
                .add(ModPaintingVariants.JOJO_SUPREMACY)
                .add(ModPaintingVariants.HAPPY_JOJO)
                .add(ModPaintingVariants.MASCOT_JOJO)
                .add(ModPaintingVariants.BURRITO_JOJO)
                .add(ModPaintingVariants.BOTW_LINK)
                .add(ModPaintingVariants.GRAHAM_JOJO)
                .add(ModPaintingVariants.JOJO_KONG)
                .add(ModPaintingVariants.JOJO_FIGHTS_DONKEY_KONG)
                .add(ModPaintingVariants.BEARSTER_CODING)

        ;
    }
}
