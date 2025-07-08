package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.block.ModBlocks;
import net.bearster.jojojetzmod.item.ModItems;
import net.bearster.jojojetzmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                               CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, tagLookupCompletableFuture, JoJoJetzMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(Tags.Items.FOODS)
                .add(ModItems.BURRITO.get())
                .add(ModItems.SPARKLING_WATER.get())
                .add(ModItems.JETZ_JUICE.get());

        tag(ModTags.Items.BURRITO_FOOD)
                .add(Items.BEEF)
                .add(Items.BREAD)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.RED_MUSHROOM)
                .add(Items.COOKED_BEEF)
                .add(Items.COOKED_CHICKEN)
                .add(Items.COOKED_MUTTON)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.POTATO);

        tag(ItemTags.DYEABLE)
                .add(ModItems.HEADBAND.get());

        tag(ModTags.Items.JOJOJETZ_ITEMS)
                .add(ModItems.BURRITO.get())
                .add(ModItems.SPARKLING_WATER.get())
                .add(ModItems.JETZ_JUICE.get())
                .add(ModBlocks.GAMECUBE.get().asItem())
                .add(ModItems.HEADBAND.get())
                .add(ModItems.FEDORA.get())
                .add(ModItems.FIREFIGHTER_HELMET.get())
                .add(ModItems.FIREFIGHTER_CHESTPLATE.get())
                .add(ModItems.FIREFIGHTER_LEGGINGS.get())
                .add(ModItems.FIREFIGHTER_BOOTS.get())
                .add(ModItems.CHAIRCHAIRJETZ.get())
                .add(ModItems.FIREFIGHTER.get())
                .add(ModItems.FIRE_TRUCK.get())
                .add(ModItems.GOOSE.get())
                .add(ModItems.OLD_MAN.get())
                .add(ModItems.JOJO_LINK.get())
                .add(ModItems.JOJO_PIKMIN.get())
                .add(ModItems.JOJOJETZ.get())

                .add(ModItems.JETZ_CULT_MUSIC_DISC.get())
                .add(ModItems.JETZ_CLUB_MUSIC_DISC.get())
                .add(ModItems.CRAZY_MUSIC_DISC.get())
                .add(ModItems.JEBAITED_MUSIC_DISC.get())
                .add(ModItems.JETZ_CULT_GIRLS_MUSIC_DISC.get())
                .add(ModItems.JOJO_STAMINA_MUSIC_DISC.get())
                .add(ModItems.KITTY_KITTY_MUSIC_DISC.get())
                .add(ModItems.OLD_ZELDA_MUSIC_DISC.get())
                .add(ModItems.TROLOL_MUSIC_DISC.get())
                .add(ModItems.YES_GLENN_MUSIC_DISC.get());

    }
}
