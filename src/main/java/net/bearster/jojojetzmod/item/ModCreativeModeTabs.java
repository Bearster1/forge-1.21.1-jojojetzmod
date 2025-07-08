package net.bearster.jojojetzmod.item;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.block.ModBlocks;
import net.bearster.jojojetzmod.datagen.registry.ModPaintingVariants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JoJoJetzMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JOJOJETZ_MOD_TAB = CREATIVE_MODE_TABS.register("jojojetz_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JETZ_CULT_MUSIC_DISC.get()))
                    .title(Component.translatable("creativetab.jojojetz_mod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.JETZ_CULT_MUSIC_DISC.get());

                        output.accept(ModItems.JETZ_CLUB_MUSIC_DISC.get());
                        output.accept(ModItems.CRAZY_MUSIC_DISC.get());
                        output.accept(ModItems.JEBAITED_MUSIC_DISC.get());
                        output.accept(ModItems.JETZ_CULT_GIRLS_MUSIC_DISC.get());
                        output.accept(ModItems.JOJO_STAMINA_MUSIC_DISC.get());
                        output.accept(ModItems.KITTY_KITTY_MUSIC_DISC.get());
                        output.accept(ModItems.OLD_ZELDA_MUSIC_DISC.get());
                        output.accept(ModItems.TROLOL_MUSIC_DISC.get());
                        output.accept(ModItems.YES_GLENN_MUSIC_DISC.get());

                        output.accept(ModItems.BURRITO.get());
                        output.accept(ModItems.SPARKLING_WATER.get());
                        output.accept(ModItems.JETZ_JUICE.get());

                        output.accept(ModBlocks.GAMECUBE.get());

                        output.accept(ModItems.HEADBAND.get());
                        output.accept(ModItems.FEDORA.get());

                        output.accept(ModItems.FIREFIGHTER_HELMET.get());
                        output.accept(ModItems.FIREFIGHTER_CHESTPLATE.get());
                        output.accept(ModItems.FIREFIGHTER_LEGGINGS.get());
                        output.accept(ModItems.FIREFIGHTER_BOOTS.get());

                        output.accept(ModItems.CHAIRCHAIRJETZ.get());

                        output.accept(ModItems.FIREFIGHTER.get());
                        output.accept(ModItems.FIRE_TRUCK.get());

                        output.accept(ModItems.GOOSE.get());

                        output.accept(ModItems.OLD_MAN.get());

                        output.accept(ModItems.JOJO_LINK.get());

                        output.accept(ModItems.JOJO_PIKMIN.get());

                        output.accept(ModItems.JOJOJETZ.get());


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
