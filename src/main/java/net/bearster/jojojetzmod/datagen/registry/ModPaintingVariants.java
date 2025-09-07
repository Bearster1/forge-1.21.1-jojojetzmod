package net.bearster.jojojetzmod.datagen.registry;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.decoration.PaintingVariants;

import java.util.Optional;

public class ModPaintingVariants {
    public static final ResourceKey<PaintingVariant> JOJO_KNIGHT = create("jojo_knight");
    public static final ResourceKey<PaintingVariant> JJJC_PROPAGANDA = create("jjjc_propaganda");
    public static final ResourceKey<PaintingVariant> JOJO_BOTW = create("jojo_botw");
    public static final ResourceKey<PaintingVariant> LEGEND_OF_DAVIE = create("legend_of_davie");
    public static final ResourceKey<PaintingVariant> TASTY_DISCO = create("tasty_disco");
    public static final ResourceKey<PaintingVariant> JOJO_SUPREMACY = create("jojo_supremacy");
    public static final ResourceKey<PaintingVariant> HAPPY_JOJO = create("happy_jojo");
    public static final ResourceKey<PaintingVariant> MASCOT_JOJO = create("mascot_jojo");
    public static final ResourceKey<PaintingVariant> BURRITO_JOJO = create("burrito_jojo");
    public static final ResourceKey<PaintingVariant> BOTW_LINK = create("botw_link");
    public static final ResourceKey<PaintingVariant> GRAHAM_JOJO = create("graham_jojo");
    public static final ResourceKey<PaintingVariant> JOJO_KONG = create("jojo_kong");
    public static final ResourceKey<PaintingVariant> JOJO_FIGHTS_DONKEY_KONG = create("jojo_fights_donkey_kong");
    public static final ResourceKey<PaintingVariant> BEARSTER_CODING = create("bearster_coding");
    public static final ResourceKey<PaintingVariant> BEARSTER_STARGLAZING = create("bearster_starglazing");
    public static final ResourceKey<PaintingVariant> BEARSTER_PFP = create("bearster_pfp");
    public static final ResourceKey<PaintingVariant> GOOGOOPROTECT = create("googooprotect");
    public static final ResourceKey<PaintingVariant> JIELD = create("jield");

    public static final ResourceKey<PaintingVariant> MIDNA = create("midna");
    public static final ResourceKey<PaintingVariant> ABADAB_PFP = create("abadab_pfp");
    public static final ResourceKey<PaintingVariant> CROCHET_GIRLY_PFP = create("crochet_girly_pfp");
    public static final ResourceKey<PaintingVariant> CROCHETY_GIRL_PFP = create("crochety_girl_pfp");
    public static final ResourceKey<PaintingVariant> DDDF_PFP = create("dddf_pfp");
    public static final ResourceKey<PaintingVariant> DREAMSICLE_PFP = create("dreamsicle_pfp");
    public static final ResourceKey<PaintingVariant> ETHAN_BOOKS_PFP = create("ethan_books_pfp");
    public static final ResourceKey<PaintingVariant> GAME_OVER_PFP = create("game_over_pfp");
    public static final ResourceKey<PaintingVariant> GAMO_PFP = create("gamo_pfp");
    public static final ResourceKey<PaintingVariant> GLACKER_PFP = create("glacker_pfp");
    public static final ResourceKey<PaintingVariant> GOOGOOGYATZ_PFP = create("googoogyatz_pfp");
    public static final ResourceKey<PaintingVariant> HERB_PFP = create("herb_pfp");
    public static final ResourceKey<PaintingVariant> JESSICA_PFP = create("jessica_pfp");
    public static final ResourceKey<PaintingVariant> JOSEY_PFP = create("josey_pfp");
    public static final ResourceKey<PaintingVariant> KIDO_PFP = create("kido_pfp");
    public static final ResourceKey<PaintingVariant> KRISTY_PFP = create("kristy_pfp");
    public static final ResourceKey<PaintingVariant> LEXI_PFP = create("lexi_pfp");
    public static final ResourceKey<PaintingVariant> LOST_HYLIAN_PFP = create("lost_hylian_pfp");
    public static final ResourceKey<PaintingVariant> LUCAS_PFP = create("lucas_pfp");
    public static final ResourceKey<PaintingVariant> MK_PFP = create("mk_pfp");
    public static final ResourceKey<PaintingVariant> MR_EPIC_PFP = create("mr_epic_pfp");
    public static final ResourceKey<PaintingVariant> MURK_PFP = create("murk_pfp");
    public static final ResourceKey<PaintingVariant> NIGHTBLOOD_PFP = create("nightblood_pfp");
    public static final ResourceKey<PaintingVariant> PAVLOVA_PFP = create("pavlova_pfp");
    public static final ResourceKey<PaintingVariant> PERSON_PFP = create("person_pfp");
    public static final ResourceKey<PaintingVariant> PLUMMAH_PFP = create("plummah_pfp");
    public static final ResourceKey<PaintingVariant> SCRVBZ_PFP = create("scrvbz_pfp");
    public static final ResourceKey<PaintingVariant> SHADOWWOLF_PFP = create("shadowwolf_pfp");
    public static final ResourceKey<PaintingVariant> THE_DDDF_PFP = create("the_dddf_pfp");
    public static final ResourceKey<PaintingVariant> VOCA_PFP = create("voca_pfp");
    public static final ResourceKey<PaintingVariant> WILLIAM_PFP = create("william_pfp");
    public static final ResourceKey<PaintingVariant> YOUR_LOCAL_PLUMBER_PFP = create("your_local_plumber_pfp");
    public static final ResourceKey<PaintingVariant> SONIC_DA_QUEEN_PFP = create("sonic_da_queen_pfp");
    public static final ResourceKey<PaintingVariant> LEXI_GUN = create("lexi_gun");




    public static void bootstrap(BootstrapContext<PaintingVariant> pContext) {
        register(pContext, JOJO_KNIGHT, 7, 3);
        register(pContext, JJJC_PROPAGANDA, 1, 3);
        register(pContext, JOJO_BOTW, 7, 3);
        register(pContext, LEGEND_OF_DAVIE, 1, 3);
        register(pContext, TASTY_DISCO, 1, 1);
        register(pContext, JOJO_SUPREMACY, 3, 3);
        register(pContext, HAPPY_JOJO, 3, 1);
        register(pContext, MASCOT_JOJO, 3, 3);
        register(pContext, BURRITO_JOJO, 1, 1);
        register(pContext, BOTW_LINK, 1, 3);
        register(pContext, GRAHAM_JOJO, 1, 3);
        register(pContext, JOJO_KONG, 3, 1);
        register(pContext, JOJO_FIGHTS_DONKEY_KONG, 1, 3);
        register(pContext, BEARSTER_CODING, 3, 3);
        register(pContext, BEARSTER_STARGLAZING, 3,1);
        register(pContext, BEARSTER_PFP, 1, 1);
        register(pContext, GOOGOOPROTECT, 1, 1);
        register(pContext, JIELD, 1, 1);

        register(pContext, MIDNA, 1, 1);
        register(pContext, ABADAB_PFP, 1, 1);
        register(pContext, CROCHET_GIRLY_PFP, 1, 1);
        register(pContext, CROCHETY_GIRL_PFP, 1, 1);
        register(pContext, DDDF_PFP, 1, 1);
        register(pContext, DREAMSICLE_PFP, 1, 1);
        register(pContext, ETHAN_BOOKS_PFP, 1, 1);
        register(pContext, GAME_OVER_PFP, 1, 1);
        register(pContext, GAMO_PFP, 1, 1);
        register(pContext, GLACKER_PFP, 1, 1);
        register(pContext, GOOGOOGYATZ_PFP, 1, 1);
        register(pContext, HERB_PFP, 1, 1);
        register(pContext, JESSICA_PFP, 1, 1);
        register(pContext, JOSEY_PFP, 1, 1);
        register(pContext, KIDO_PFP, 1, 1);
        register(pContext, KRISTY_PFP, 1, 1);
        register(pContext, LEXI_PFP, 1, 1);
        register(pContext, LOST_HYLIAN_PFP, 1, 1);
        register(pContext, LUCAS_PFP, 1, 1);
        register(pContext, MK_PFP, 1, 1);
        register(pContext, MR_EPIC_PFP, 1, 1);
        register(pContext, MURK_PFP, 1, 1);
        register(pContext, NIGHTBLOOD_PFP, 1, 1);
        register(pContext, PAVLOVA_PFP, 1, 1);
        register(pContext, PERSON_PFP, 1, 1);
        register(pContext, PLUMMAH_PFP, 1, 1);
        register(pContext, SCRVBZ_PFP, 1, 1);
        register(pContext, SHADOWWOLF_PFP, 1, 1);
        register(pContext, THE_DDDF_PFP, 1, 1);
        register(pContext, VOCA_PFP, 1, 1);
        register(pContext, WILLIAM_PFP, 1, 1);
        register(pContext, YOUR_LOCAL_PLUMBER_PFP, 1, 1);
        register(pContext, SONIC_DA_QUEEN_PFP, 1, 1);
        register(pContext, LEXI_GUN, 1, 1);
    }

    private static ResourceKey<PaintingVariant> create(String pName) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, pName));
    }

    private static void register(BootstrapContext<PaintingVariant> pContext, ResourceKey<PaintingVariant> pKey, int pWidth, int pHeight) {
        pContext.register(pKey, new PaintingVariant(pWidth, pHeight, pKey.location()));
    }
}
