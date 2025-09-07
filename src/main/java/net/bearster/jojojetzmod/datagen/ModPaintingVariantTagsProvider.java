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
                .add(ModPaintingVariants.BEARSTER_STARGLAZING)
                .add(ModPaintingVariants.BEARSTER_PFP)
                .add(ModPaintingVariants.GOOGOOPROTECT)
                .add(ModPaintingVariants.MIDNA)
                .add(ModPaintingVariants.ABADAB_PFP)
                .add(ModPaintingVariants.CROCHET_GIRLY_PFP)
                .add(ModPaintingVariants.CROCHETY_GIRL_PFP)
                .add(ModPaintingVariants.DDDF_PFP)
                .add(ModPaintingVariants.DREAMSICLE_PFP)
                .add(ModPaintingVariants.ETHAN_BOOKS_PFP)
                .add(ModPaintingVariants.GAME_OVER_PFP)
                .add(ModPaintingVariants.GAMO_PFP)
                .add(ModPaintingVariants.GLACKER_PFP)
                .add(ModPaintingVariants.GOOGOOGYATZ_PFP)
                .add(ModPaintingVariants.HERB_PFP)
                .add(ModPaintingVariants.JESSICA_PFP)
                .add(ModPaintingVariants.JOSEY_PFP)
                .add(ModPaintingVariants.KIDO_PFP)
                .add(ModPaintingVariants.KRISTY_PFP)
                .add(ModPaintingVariants.LEXI_PFP)
                .add(ModPaintingVariants.LOST_HYLIAN_PFP)
                .add(ModPaintingVariants.LUCAS_PFP)
                .add(ModPaintingVariants.MK_PFP)
                .add(ModPaintingVariants.MR_EPIC_PFP)
                .add(ModPaintingVariants.MURK_PFP)
                .add(ModPaintingVariants.NIGHTBLOOD_PFP)
                .add(ModPaintingVariants.PAVLOVA_PFP)
                .add(ModPaintingVariants.PERSON_PFP)
                .add(ModPaintingVariants.PLUMMAH_PFP)
                .add(ModPaintingVariants.SCRVBZ_PFP)
                .add(ModPaintingVariants.SHADOWWOLF_PFP)
                .add(ModPaintingVariants.THE_DDDF_PFP)
                .add(ModPaintingVariants.VOCA_PFP)
                .add(ModPaintingVariants.WILLIAM_PFP)
                .add(ModPaintingVariants.YOUR_LOCAL_PLUMBER_PFP)
                .add(ModPaintingVariants.SONIC_DA_QUEEN_PFP)
                .add(ModPaintingVariants.LEXI_GUN)
        ;
    }
}
