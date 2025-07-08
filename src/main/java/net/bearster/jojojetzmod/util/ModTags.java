package net.bearster.jojojetzmod.util;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name));
        }


    }

    public static class Items {

        public static final TagKey<Item> BURRITO_FOOD = createTag("burrito_food");
        public static final TagKey<Item> JOJOJETZ_ITEMS = createTag("jojojetz_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name));
        }

    }

    public class Biomes {
        public static final TagKey<Biome> HAS_MUSIC_MACHINE = createTag("has_structure/music_machine");
        public static final TagKey<Biome> HAS_FIRE_TRUCK = createTag("has_structure/fire_truck");
        public static final TagKey<Biome> HAS_FIRE_STATION = createTag("has_structure/fire_station");

        private static TagKey<Biome> createTag(String name) {
            return BiomeTags.create(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name));
        }

    }

}
