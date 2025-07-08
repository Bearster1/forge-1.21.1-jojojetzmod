package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.sound.ModSounds;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import static net.bearster.jojojetzmod.sound.ModSounds.*;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {

    public ModSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, JoJoJetzMod.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.CRAZY.get(), definition()
                .subtitle("items.jojojetzmod.crazy_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "crazy")).stream(true)));
        add(ModSounds.JEBAITED.get(), definition()
                .subtitle("item.jojojetzmod.jebaited_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "jebaited")).stream(true)));
        add(ModSounds.JETZ_CULT_GIRLS.get(), definition()
                .subtitle("item.jojojetzmod.jetz_cult_girls_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "jetz_cult_girls")).stream(true)));
        add(ModSounds.JOJO_STAMINA.get(), definition()
                .subtitle("item.jojojetzmod.jojo_stamina_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "jojo_stamina")).stream(true)));
        add(ModSounds.KITTY_KITTY.get(), definition()
                .subtitle("item.jojojetzmod.kitty_kitty_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "kitty_kitty")).stream(true)));
        add(ModSounds.OLD_ZELDA.get(), definition()
                .subtitle("item.jojojetzmod.old_zelda_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "old_zelda")).stream(true)));
        add(ModSounds.TROLOL.get(), definition()
                .subtitle("item.jojojetzmod.trolol_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "trolol")).stream(true)));
        add(JETZ_CULT.get(), definition()
                .subtitle("item.jojojetzmod.jetz_cult_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "jetz_cult")).stream(true)));
        add(ModSounds.JETZ_CLUB.get(), definition()
                .subtitle("item.jojojetzmod.jetz_club_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "jetz_club")).stream(true)));
        add(YES_GLENN.get(), definition()
                .subtitle("item.jojojetzmod.yes_glenn_music_disc")
                .with(sound(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, "yes_glenn")).stream(true)));
        add(FIREFIGHTER.get(), definition()
                .subtitle("sounds.jojojetzmod.firefighter")
                .with(sound(JoJoJetzMod.loc("firefighter"))));
    }

    private static ResourceKey<JukeboxSong> create(String pName) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.withDefaultNamespace(pName));
    }

    private static void register(BootstrapContext<JukeboxSong> pContext, ResourceKey<JukeboxSong> pKey,
                                 Holder<SoundEvent> pSoundEvent, int pLengthInSeconds, int pComparatorOutput
    ) {
        pContext.register(
                pKey, new JukeboxSong(pSoundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", pKey.location())), (float)pLengthInSeconds, pComparatorOutput)
        );
    }

    public static void bootstrap(BootstrapContext<JukeboxSong> pContext) {
        register(pContext, JETZ_CULT_KEY, JETZ_CULT.getHolder().orElseThrow(), 28, 15);
        register(pContext, CRAZY_KEY, CRAZY.getHolder().orElseThrow(), 24, 15);
        register(pContext, JEBAITED_KEY, JEBAITED.getHolder().orElseThrow(), 17, 15);
        register(pContext, JETZ_CLUB_KEY, JETZ_CLUB.getHolder().orElseThrow(), 25, 15);
        register(pContext, JETZ_CULT_GIRLS_KEY, JETZ_CULT_GIRLS.getHolder().orElseThrow(), 27, 15);
        register(pContext, JOJO_STAMINA_KEY, JOJO_STAMINA.getHolder().orElseThrow(), 82, 15);
        register(pContext, KITTY_KITTY_KEY, KITTY_KITTY.getHolder().orElseThrow(), 15, 15);
        register(pContext, OLD_ZELDA_KEY, OLD_ZELDA.getHolder().orElseThrow(), 22, 15);
        register(pContext, TROLOL_KEY, TROLOL.getHolder().orElseThrow(), 25, 15);
        register(pContext, YES_GLENN_KEY, YES_GLENN.getHolder().orElseThrow(), 28, 15);
    }

}
