package net.bearster.jojojetzmod.datagen;

import com.mojang.logging.LogUtils;
import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.block.ModBlocks;
import net.bearster.jojojetzmod.datagen.registry.ModPaintingVariants;
import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.item.ModCreativeModeTabs;
import net.bearster.jojojetzmod.item.ModItems;
import net.bearster.jojojetzmod.sound.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.slf4j.Logger;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, JoJoJetzMod.MOD_ID, "en_us");
    }

    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    protected void addTranslations() {

        LOGGER.info("Adding Mod Translations" + " "+ ModPaintingVariants.JOJO_KNIGHT.location());

        add(ModItems.BURRITO.get(), "Burrito");
        add(ModItems.SPARKLING_WATER.get(), "Sparkling Water");
        add(ModItems.JETZ_JUICE.get(), "Jetz Juice");
        basicTranslation(ModItems.MILK_BOTTLE.get());

        add(ModItems.HEADBAND.get(), "Headband");
        add(ModItems.FEDORA.get(), "Fedora");

        add(ModItems.FIREFIGHTER_HELMET.get(), "Firefighter Helmet");
        add(ModItems.FIREFIGHTER_CHESTPLATE.get(), "Firefighter Chestplate");
        add(ModItems.FIREFIGHTER_LEGGINGS.get(), "Firefighter Leggings");
        add(ModItems.FIREFIGHTER_BOOTS.get(), "Firefighter Boots");

        add(ModItems.CHAIRCHAIRJETZ.get(), "ChairChairJetz");
        add(ModItems.FIREFIGHTER.get(), "Firefighter");
        add(ModItems.FIRE_TRUCK.get(), "Fire Truck");
        add(ModItems.GOOSE.get(), "Goose");
        add(ModItems.OLD_MAN.get(), "Old Man");
        add(ModItems.JOJO_LINK.get(), "J0J0 Link");
        add(ModItems.JOJO_PIKMIN.get(), "J0J0 Pikmin");
        add(ModItems.JOJOJETZ.get(), "J0J0Jetz");

        basicTranslation(ModItems.PENCIL.get());
        basicTranslation(ModItems.PLUNGER.get());
        add(ModItems.GK_LIGHTSABER.get(), "General Kenobi's Lightsaber");

        add(ModItems.LEXI_GUN.get(),"Lexi's Gun");
        basicTranslation(ModItems.LEXI_BULLET.get());
        basicTranslation(ModItems.LEXI_BULLET.get());

        addNameType("master_sword","Master Sword");
        addNameType("hylian_shield","Hylian Shield");

        add(ModBlocks.GAMECUBE.get(), "GameCube");

        addCreativeTabType(ModCreativeModeTabs.JOJOJETZ_MOD_TAB.get(), "J0J0Jetz Mod");


        add(ModEntities.CHAIRCHAIRJETZ.get(), "ChairChairJetz");
        add(ModEntities.FIREFIGHTER.get(), "Firefighter");
        add(ModEntities.FIRE_TRUCK.get(), "Fire Truck");
        add(ModEntities.GOOSE.get(), "Goose");
        add(ModEntities.OLD_MAN.get(), "Old Man");
        add(ModEntities.JOJO_LINK.get(), "J0J0 Link");
        add(ModEntities.JOJO_PIKMIN.get(), "J0J0 Pikmin");
        add(ModEntities.JOJO_PIKMIN_PROJECTILE.get(), "J0J0 Pikmin");
        add(ModEntities.JOJOJETZ.get(), "J0J0Jetz");


        addMusicDiscType(ModSounds.CRAZY.get(), "Crazy", "J0J0Jetz - Crazy");
        addMusicDiscType(ModSounds.JETZ_CULT.get(), "Jetz Cult", "J0J0Jetz - Jetz Cult");
        addMusicDiscType(ModSounds.JEBAITED.get(), "Jebaited", "J0J0Jetz - Jebaited");
        addMusicDiscType(ModSounds.JETZ_CULT_GIRLS.get(), "Jetz Cult Girls", "J0J0Jetz - Jetz Cult Girls");
        addMusicDiscType(ModSounds.JOJO_STAMINA.get(), "J0J0 Stamina", "J0J0Jetz - J0J0 Stamina");
        addMusicDiscType(ModSounds.KITTY_KITTY.get(), "Kitty Kitty", "J0J0Jetz - Kitty Kitty");
        addMusicDiscType(ModSounds.OLD_ZELDA.get(), "Old Zelda", "J0J0Jetz - Old Zelda");
        addMusicDiscType(ModSounds.TROLOL.get(), "Trolol", "J0J0Jetz - Trolol");
        addMusicDiscType(ModSounds.JETZ_CLUB.get(), "Jetz Club", "J0J0Jetz - Jetz Club");
        addMusicDiscType(ModSounds.YES_GLENN.get(), "Yes Glenn", "J0J0Jetz - Yes Glenn");

        addSoundType(ModSounds.FIREFIGHTER.get(), "Firefighter Noises");
        addSoundType(ModSounds.PIKMIN.get(), "Pikmin Hitting Ground");
        addSoundType(ModSounds.LEXI_SHOT.get(), "Lexi Gun Firing");

        addPaintingType(ModPaintingVariants.JOJO_KNIGHT, "J0J0Jetz Getting Knighted", "HobbyBox");
        addPaintingType(ModPaintingVariants.JJJC_PROPAGANDA, "J0J0Jetz Propaganda","scrvbZ");
        addPaintingType(ModPaintingVariants.JOJO_BOTW, "J0J0Jetz In Breath Of The Wild","J0J0Jetz");
        addPaintingType(ModPaintingVariants.LEGEND_OF_DAVIE, "The Legend Of Davie","Dreamsicle");
        addPaintingType(ModPaintingVariants.TASTY_DISCO, "Tasty Disco","scrvbZ");
        addPaintingType(ModPaintingVariants.JOJO_SUPREMACY, "J0J0Jetz Supremacy","Kido");
        addPaintingType(ModPaintingVariants.HAPPY_JOJO, "Happy J0J0Jetz","scrvbZ");
        addPaintingType(ModPaintingVariants.MASCOT_JOJO, "Mascot J0J0Jetz","Jackaboi");
        addPaintingType(ModPaintingVariants.BURRITO_JOJO, "Burrito J0J0Jetz","scrvbZ");
        addPaintingType(ModPaintingVariants.BOTW_LINK, "Link From BOTW","Aiden");
        addPaintingType(ModPaintingVariants.GRAHAM_JOJO, "Graham J0J0Jetz","Murk, Captain of the Feline Seas");
        addPaintingType(ModPaintingVariants.JOJO_KONG, "J0J0 Kong","Bearster");
        addPaintingType(ModPaintingVariants.JOJO_FIGHTS_DONKEY_KONG, "J0J0Jetz Fighting Donkey Kong","scrvbZ");
        addPaintingType(ModPaintingVariants.BEARSTER_CODING, "Bearster Coding","scrvbZ");
        addPaintingType(ModPaintingVariants.BEARSTER_STARGLAZING, "Bearster Starglazing","Nightblood");
        addPaintingType(ModPaintingVariants.BEARSTER_PFP,"Bearster Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.GOOGOOPROTECT, "GooGooProtect","HobbyBox");
        addPaintingType(ModPaintingVariants.JIELD, "Jield","Jackaboi");
        addPaintingType(ModPaintingVariants.MIDNA,"Midna","HobbyBox");
        addPaintingType(ModPaintingVariants.ABADAB_PFP,"Abadab Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.CROCHET_GIRLY_PFP,"Crochet Girly Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.CROCHETY_GIRL_PFP,"Crochety Girl Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.DDDF_PFP,"DDDF Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.DREAMSICLE_PFP,"Dreamsicle Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.ETHAN_BOOKS_PFP,"Ethan's Books Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.GAME_OVER_PFP,"Game Over Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.GAMO_PFP,"Gamo Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.GLACKER_PFP,"Glacker Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.GOOGOOGYATZ_PFP,"GooGooGyatz Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.HERB_PFP,"Herb Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.JESSICA_PFP,"Jessica Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.JOSEY_PFP,"Josey Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.KIDO_PFP,"Kido Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.KRISTY_PFP,"Kristy Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.LEXI_PFP,"Lexi Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.LOST_HYLIAN_PFP,"Lost Hylian Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.LUCAS_PFP,"LucasPapaG Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.MK_PFP,"MK Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.MR_EPIC_PFP,"Mr Epic Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.MURK_PFP,"Murk Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.NIGHTBLOOD_PFP,"Nightblood Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.PAVLOVA_PFP,"Pavlova Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.PERSON_PFP,"Person Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.PLUMMAH_PFP,"Plummah Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.SCRVBZ_PFP,"scrvbZ Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.SHADOWWOLF_PFP,"ShadowWolf Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.THE_DDDF_PFP,"The DDDF Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.VOCA_PFP,"Voca Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.WILLIAM_PFP,"William Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.YOUR_LOCAL_PLUMBER_PFP,"Your.Local.Plumber Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.SONIC_DA_QUEEN_PFP,"Sonic Da Queen Profile Picture","HobbyBox");
        addPaintingType(ModPaintingVariants.LEXI_GUN, "Lexi Gun","Herb");

        addAdvancementType("root", "The Beginning", "This is the beginning of the J0J0Jetz achievements. Tip: Combine the headband with 2 magenta dye 1 pink dye and 1 red dye.");

        addAdvancementType("kill_firefighter","Hiccup Has Been Banned", "Kill a firefighter.");
        addAdvancementType("firefighter_helmet","The Hat Of A Firefighter", "Get a firefighter helmet.");
        addAdvancementType("firefighter_chestplate","The Body Of A Firefighter", "Get a firefighter chestplate.");
        addAdvancementType("firefighter_leggings","The Legs Of A Firefighter", "Get firefighter leggings.");
        addAdvancementType("firefighter_boots","The Boots Of A Firefighter", "Get firefighter boots.");
        addAdvancementType("firefighter","Big Bulky Firefighter","Get a firefighter.");
        addAdvancementType("fire_truck","The Greatest Car Of All Time", "Get a fire truck.");

        addAdvancementType("jojo_pikmin", "Destroyed And Put Back Again", "Get a J0J0 pikmin.");

        addAdvancementType("fedora","M' Lady","Get a fedora.");

        addAdvancementType("jetz_cult_music_disc","A brand new Jetz", "Get the Jetz Cult music disc.");
        addAdvancementType("jojojetzmod_music_discs","The True Sound Of Music", "Collect every J0J0Jetz music disc.");

        addAdvancementType("kill_jojojetz","Our Leader Is Dead", "Kill J0J0Jetz.");

        addAdvancementType("old_man","Ohhh, I remeber","Get an Old Man.");

        addAdvancementType("kill_jojo_link","Ganon will remember this action","Kill J0J0 Link");

        addAdvancementType("lexi_gun","Lexi's Got A Gun, Everybody Run.","Get the Lexi Gun");

    }

    public void addCreativeTabType(CreativeModeTab creativeModeTab, String name) {
        add(creativeModeTab.getDisplayName().getString(), name);
    }

    public void addMusicDiscType(SoundEvent songIdentifier, String songName, String description) {
        String song = songIdentifier.getLocation().toString();
        String newSong = song.replace(':','.');
        add("item."+newSong+"_music_disc", songName+" Music Disc");
        add("jukebox_song."+newSong, description);

    }

    public void addSoundType(SoundEvent soundIdentifier, String soundName) {
        String sound = soundIdentifier.getLocation().toString();
        String newSound = sound.replace(':','.');
        add("sounds."+newSound, soundName);

    }

    public void addPaintingType(ResourceKey paintingVariants, String paintingName, String paintingAuthor) {
        String painting = paintingVariants.location().toString();
        String newPainting = painting.replace(':','.');
        add("painting."+newPainting+".title", paintingName);
        add("painting."+newPainting+".author", paintingAuthor);

    }

    public void addNameType(String keyName, String translatedName) {
        add("name.jojojetzmod."+keyName, translatedName);
    }

    public void addAdvancementType(String keyName,
                                   String translatedTitle,
                                   String translatedDescription) {
        add("advancements.jojojetzmod."+keyName+".title", translatedTitle);
        add("advancements.jojojetzmod."+keyName+".description", translatedDescription);
    }

    public void basicTranslation(Item item) {
        String name = item.getDescriptionId().replace('_',' ');
        String[] names = name.split("\\.");
        name = names[2];
        String[] parts = name.split("\\s");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
        }
        name = "";
        for (int i = 0; i < parts.length; i++) {
            if (i < parts.length - 1) {
                name = name + parts[i] + " ";
            } else {
                name = name + parts[i];
            }
        }

        add(item, name);
    }

    public void basicTranslation(Block block) {
        String name = block.getDescriptionId().replace('_',' ');
        String[] names = name.split("\\.");
        name = names[2];
        String[] parts = name.split("\\s");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
        }
        name = "";
        for (int i = 0; i < parts.length; i++) {
            if (i < parts.length - 1) {
                name = name + parts[i] + " ";
            } else {
                name = name + parts[i];
            }
        }

        add(block, name);
    }
}
