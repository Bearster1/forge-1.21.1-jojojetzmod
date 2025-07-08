package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JoJoJetzMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BURRITO.get());
        basicItem(ModItems.SPARKLING_WATER.get());
        basicItem(ModItems.JETZ_JUICE.get());

        basicItem(ModItems.HEADBAND.get());
        basicItem(ModItems.FEDORA.get());

        basicItem(ModItems.FIREFIGHTER_HELMET.get());
        basicItem(ModItems.FIREFIGHTER_CHESTPLATE.get());
        basicItem(ModItems.FIREFIGHTER_LEGGINGS.get());
        basicItem(ModItems.FIREFIGHTER_BOOTS.get());

        basicItem(ModItems.CRAZY_MUSIC_DISC.get());
        basicItem(ModItems.JEBAITED_MUSIC_DISC.get());
        basicItem(ModItems.JETZ_CULT_GIRLS_MUSIC_DISC.get());
        basicItem(ModItems.JOJO_STAMINA_MUSIC_DISC.get());
        basicItem(ModItems.KITTY_KITTY_MUSIC_DISC.get());
        basicItem(ModItems.OLD_ZELDA_MUSIC_DISC.get());
        basicItem(ModItems.TROLOL_MUSIC_DISC.get());
        basicItem(ModItems.JETZ_CULT_MUSIC_DISC.get());
        basicItem(ModItems.JETZ_CLUB_MUSIC_DISC.get());
        basicItem(ModItems.YES_GLENN_MUSIC_DISC.get());

        basicItem(ModItems.CHAIRCHAIRJETZ.get());
        basicItem(ModItems.FIRE_TRUCK.get());
        basicItem(ModItems.FIREFIGHTER.get());
        basicItem(ModItems.GOOSE.get());
        basicItem(ModItems.OLD_MAN.get());
        basicItem(ModItems.JOJO_LINK.get());
        basicItem(ModItems.JOJO_PIKMIN.get());
        basicItem(ModItems.JOJOJETZ.get());

    }

    private ItemModelBuilder horizontalBlockItem(RegistryObject<Block> block) {
        return getBuilder(block.getId().getPath()).parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID,
                "block/" + block.getId().getPath())));
    }
}
