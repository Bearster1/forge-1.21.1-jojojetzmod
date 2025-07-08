package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.client.ModCatVariants;
import net.bearster.jojojetzmod.mixin.CatVariantMixin;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.CatVariantTagsProvider;
import net.minecraft.tags.CatVariantTags;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModCatVariantTagsProvider extends CatVariantTagsProvider {

    public ModCatVariantTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, JoJoJetzMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(CatVariantTags.DEFAULT_SPAWNS)
                .add(
                        ModCatVariants.DISCO,
                        ModCatVariants.DAVIE,
                        ModCatVariants.ARCHIE);
        this.tag(CatVariantTags.FULL_MOON_SPAWNS).addTag(CatVariantTags.DEFAULT_SPAWNS).add(CatVariant.ALL_BLACK);
    }
}
