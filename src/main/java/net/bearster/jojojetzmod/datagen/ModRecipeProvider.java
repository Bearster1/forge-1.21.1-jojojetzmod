package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.block.ModBlocks;
import net.bearster.jojojetzmod.item.ModItems;
import net.bearster.jojojetzmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BURRITO.get())
                .pattern("BBB")
                .pattern("BFF")
                .pattern("BBB")
                .define('B', Items.BREAD)
                .define('F', ModTags.Items.BURRITO_FOOD)
                .unlockedBy("has_burrito_food", has(ModTags.Items.BURRITO_FOOD)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SPARKLING_WATER.get())
                        .requires(Items.GLASS_BOTTLE)
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.ICE)
                        .requires(Items.SUGAR)
                        .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.JETZ_JUICE.get())
                .pattern(" P ")
                .pattern("LAL")
                .pattern("GPG")
                .define('P', Items.PAPER)
                .define('L', Items.LIME_DYE)
                .define('G', Items.GREEN_DYE)
                .define('A', Items.APPLE)
                .unlockedBy("has_apple", has(Items.APPLE)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GAMECUBE.get())
                .pattern("MMM")
                .pattern("ICI")
                .pattern("MMM")
                .define('M', Items.MAGENTA_CONCRETE)
                .define('I', Items.IRON_BLOCK)
                .define('C', Items.COPPER_BLOCK)
                .unlockedBy("has_copper_block", has(Items.COPPER_BLOCK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HEADBAND.get())
                .pattern("   ")
                .pattern("SLL")
                .pattern("   ")
                .define('S', Items.STRING)
                .define('L', Items.LEATHER)
                .unlockedBy("has_leather",has(Items.LEATHER)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FEDORA.get())
                .pattern(" L ")
                .pattern("LLL")
                .pattern("   ")
                .define('L', Items.LEATHER)
                .unlockedBy("has_leather",has(Items.LEATHER)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FIREFIGHTER_HELMET.get())
                .pattern("IGI")
                .pattern("IRI")
                .pattern("   ")
                .define('G', Items.GOLD_BLOCK)
                .define('I', Items.IRON_INGOT)
                .define('R', Items.RED_DYE)
                .unlockedBy("has_iron_ingot",has(Items.IRON_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FIREFIGHTER_CHESTPLATE.get())
                .pattern("IRI")
                .pattern("III")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.RED_DYE)
                .unlockedBy("has_iron_block",has(Items.IRON_BLOCK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FIREFIGHTER_LEGGINGS.get())
                .pattern("III")
                .pattern("IRI")
                .pattern("I I")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.RED_DYE)
                .unlockedBy("has_iron_ingot",has(Items.IRON_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FIREFIGHTER_BOOTS.get())
                .pattern("IRI")
                .pattern("I I")
                .pattern("   ")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.RED_DYE)
                .unlockedBy("has_iron_ingot",has(Items.IRON_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.CHAIRCHAIRJETZ.get())
                .pattern("WHW")
                .pattern("WCW")
                .pattern(" B ")
                .define('H', ModItems.HEADBAND.get())
                .define('W', Items.WHITE_WOOL)
                .define('C', Items.CYAN_WOOL)
                .define('B', Items.BLACK_CONCRETE)
                .unlockedBy("has_headband",has(ModItems.HEADBAND.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.FIRE_TRUCK.get())
                .pattern("GGR")
                .pattern("RRR")
                .pattern("I I")
                .define('G', Items.GOLD_BLOCK)
                .define('R', Items.RED_CONCRETE)
                .define('I', Items.IRON_BLOCK)
                .unlockedBy("has_gold_block",has(Items.GOLD_BLOCK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FIREFIGHTER.get())
                .pattern("GHG")
                .pattern("CTL")
                .pattern("IBI")
                .define('H', ModItems.FIREFIGHTER_HELMET.get())
                .define('C', ModItems.FIREFIGHTER_CHESTPLATE.get())
                .define('L', ModItems.FIREFIGHTER_LEGGINGS.get())
                .define('B', ModItems.FIREFIGHTER_BOOTS.get())
                .define('T', Items.TOTEM_OF_UNDYING)
                .define('G', Items.GOLD_BLOCK)
                .define('I', Items.IRON_BLOCK)
                .unlockedBy("has_totem_of_undying",has(Items.TOTEM_OF_UNDYING)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOOSE.get())
                .pattern(" F ")
                .pattern("FTF")
                .pattern(" F ")
                .define('F', Items.FEATHER)
                .define('T', Items.TOTEM_OF_UNDYING)
                .unlockedBy("has_totem_of_undying",has(Items.TOTEM_OF_UNDYING)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OLD_MAN.get())
                .pattern(" O ")
                .pattern("WTW")
                .pattern("RWR")
                .define('O', Items.ORANGE_TERRACOTTA)
                .define('T', Items.TOTEM_OF_UNDYING)
                .define('W', Items.WHITE_WOOL)
                .define('R', Items.RED_CONCRETE)
                .unlockedBy("has_totem_of_undying",has(Items.TOTEM_OF_UNDYING)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JOJO_LINK.get())
                .pattern("LHL")
                .pattern("DTS")
                .pattern("LLL")
                .define('H', ModItems.HEADBAND.get())
                .define('D', Items.DIAMOND_SWORD)
                .define('T', Items.TOTEM_OF_UNDYING)
                .define('L', Items.LIME_WOOL)
                .define('S', Items.SHIELD)
                .unlockedBy("has_totem_of_undying",has(Items.TOTEM_OF_UNDYING)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JOJO_PIKMIN.get())
                .pattern("LH ")
                .pattern("BTB")
                .pattern("B B")
                .define('H', ModItems.HEADBAND.get())
                .define('T', Items.TOTEM_OF_UNDYING)
                .define('L', Items.OAK_LEAVES)
                .define('B', Items.LIGHT_BLUE_CONCRETE)
                .unlockedBy("has_totem_of_undying",has(Items.TOTEM_OF_UNDYING)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JOJOJETZ.get())
                .pattern(" H ")
                .pattern("JTJ")
                .pattern("JCJ")
                .define('H', ModItems.HEADBAND.get())
                .define('T', Items.TOTEM_OF_UNDYING)
                .define('J', ModTags.Items.JOJOJETZ_ITEMS)
                .define('C', ModItems.JETZ_CULT_MUSIC_DISC.get())
                .unlockedBy("has_totem_of_undying",has(Items.TOTEM_OF_UNDYING)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JETZ_CULT_MUSIC_DISC.get())
                .pattern("JJJ")
                .pattern("JJJ")
                .pattern("JJJ")
                .define('J',ModTags.Items.JOJOJETZ_ITEMS)
                .unlockedBy("has_jojojetz_items",has(ModTags.Items.JOJOJETZ_ITEMS)).save(pRecipeOutput,"jojojetzmod:jetz_cult_music_disc_from_normal_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.JETZ_CLUB_MUSIC_DISC.get())
                .requires(ModItems.JETZ_CULT_MUSIC_DISC.get())
                .unlockedBy("has_jetz_cult_music_disc", has(ModItems.JETZ_CULT_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CRAZY_MUSIC_DISC.get())
                .requires(ModItems.JETZ_CLUB_MUSIC_DISC.get())
                .unlockedBy("has_jetz_club_music_disc", has(ModItems.JETZ_CLUB_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.JEBAITED_MUSIC_DISC.get())
                .requires(ModItems.CRAZY_MUSIC_DISC.get())
                .unlockedBy("has_crazy_music_disc", has(ModItems.CRAZY_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.JETZ_CULT_GIRLS_MUSIC_DISC.get())
                .requires(ModItems.JEBAITED_MUSIC_DISC.get())
                .unlockedBy("has_jebaited_music_disc", has(ModItems.JEBAITED_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.JOJO_STAMINA_MUSIC_DISC.get())
                .requires(ModItems.JETZ_CULT_GIRLS_MUSIC_DISC.get())
                .unlockedBy("has_jetz_cult_girls_music_disc", has(ModItems.JETZ_CULT_GIRLS_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.KITTY_KITTY_MUSIC_DISC.get())
                .requires(ModItems.JOJO_STAMINA_MUSIC_DISC.get())
                .unlockedBy("has_jojo_stamina_music_disc", has(ModItems.JOJO_STAMINA_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.OLD_ZELDA_MUSIC_DISC.get())
                .requires(ModItems.KITTY_KITTY_MUSIC_DISC.get())
                .unlockedBy("has_kitty_kitty_music_disc", has(ModItems.KITTY_KITTY_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TROLOL_MUSIC_DISC.get())
                .requires(ModItems.OLD_ZELDA_MUSIC_DISC.get())
                .unlockedBy("has_old_zelda_music_disc", has(ModItems.OLD_ZELDA_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.YES_GLENN_MUSIC_DISC.get())
                .requires(ModItems.TROLOL_MUSIC_DISC.get())
                .unlockedBy("has_trolol_music_disc", has(ModItems.TROLOL_MUSIC_DISC.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.JETZ_CULT_MUSIC_DISC.get())
                .requires(ModItems.YES_GLENN_MUSIC_DISC.get())
                .unlockedBy("has_yes_glenn_music_disc", has(ModItems.YES_GLENN_MUSIC_DISC.get())).save(pRecipeOutput,"jojojetzmod:jetz_cult_music_disc_from_yes_glenn_music_disc");
    }
}
