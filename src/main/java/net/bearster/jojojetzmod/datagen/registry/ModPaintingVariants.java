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
    }

    private static ResourceKey<PaintingVariant> create(String pName) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, pName));
    }

    private static void register(BootstrapContext<PaintingVariant> pContext, ResourceKey<PaintingVariant> pKey, int pWidth, int pHeight) {
        pContext.register(pKey, new PaintingVariant(pWidth, pHeight, pKey.location()));
    }
}
