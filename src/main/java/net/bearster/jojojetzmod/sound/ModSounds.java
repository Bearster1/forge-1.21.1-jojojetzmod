package net.bearster.jojojetzmod.sound;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, JoJoJetzMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CRAZY = registerSoundEvent("crazy");
    public static final ResourceKey<JukeboxSong> CRAZY_KEY = createSong("crazy");

    public static final RegistryObject<SoundEvent> OLD_ZELDA = registerSoundEvent("old_zelda");
    public static final ResourceKey<JukeboxSong> OLD_ZELDA_KEY = createSong("old_zelda");

    public static final RegistryObject<SoundEvent> JEBAITED = registerSoundEvent("jebaited");
    public static final ResourceKey<JukeboxSong> JEBAITED_KEY = createSong("jebaited");

    public static final RegistryObject<SoundEvent> JETZ_CULT_GIRLS = registerSoundEvent("jetz_cult_girls");
    public static final ResourceKey<JukeboxSong> JETZ_CULT_GIRLS_KEY = createSong("jetz_cult_girls");

    public static final RegistryObject<SoundEvent> JOJO_STAMINA = registerSoundEvent("jojo_stamina");
    public static final ResourceKey<JukeboxSong> JOJO_STAMINA_KEY = createSong("jojo_stamina");

    public static final RegistryObject<SoundEvent> KITTY_KITTY = registerSoundEvent("kitty_kitty");
    public static final ResourceKey<JukeboxSong> KITTY_KITTY_KEY = createSong("kitty_kitty");

    public static final RegistryObject<SoundEvent> TROLOL = registerSoundEvent("trolol");
    public static final ResourceKey<JukeboxSong> TROLOL_KEY = createSong("trolol");

    public static final RegistryObject<SoundEvent> JETZ_CULT = registerSoundEvent("jetz_cult");
    public static final ResourceKey<JukeboxSong> JETZ_CULT_KEY = createSong("jetz_cult");

    public static final RegistryObject<SoundEvent> JETZ_CLUB = registerSoundEvent("jetz_club");
    public static final ResourceKey<JukeboxSong> JETZ_CLUB_KEY = createSong("jetz_club");

    public static final RegistryObject<SoundEvent> YES_GLENN = registerSoundEvent("yes_glenn");
    public static final ResourceKey<JukeboxSong> YES_GLENN_KEY = createSong("yes_glenn");

    public static final RegistryObject<SoundEvent> FIREFIGHTER = registerSoundEvent("firefighter");

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name));
    }

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
