package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.datagen.registry.ModStructures;
import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.item.ModItems;
import net.bearster.jojojetzmod.item.custom.armor.headband.HeadbandArmorItem;
import net.bearster.jojojetzmod.util.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementTree;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {

    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
                                  ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new JoJoJetzGenerator()));
    }

    public static class JoJoJetzGenerator implements AdvancementGenerator {
        @Override
        public void generate(HolderLookup.@NotNull Provider registries,
                             @NotNull Consumer<AdvancementHolder> saver,
                             @NotNull ExistingFileHelper existingFileHelper) {
            AdvancementHolder getHeadband = Advancement.Builder.advancement()
                    .display(
                            ModItems.HEADBAND.get(),
                            Component.translatable("advancements.jojojetzmod.root.title"),
                            Component.translatable("advancements.jojojetzmod.root.description"),
                            ResourceLocation.withDefaultNamespace("textures/block/amethyst_block.png"),
                            AdvancementType.TASK,
                            true,
                            true,
                            false)
                    .addCriterion("get_headband",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HEADBAND.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.root"));

            AdvancementHolder killedFirefighter = Advancement.Builder.advancement()
                    .parent(getHeadband)
                    .display(
                            ModItems.FIREFIGHTER.get(),
                            Component.translatable("advancements.jojojetzmod.kill_firefighter.title"),
                            Component.translatable("advancements.jojojetzmod.kill_firefighter.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("killed_firefighter", KilledTrigger.TriggerInstance
                            .playerKilledEntity(EntityPredicate.Builder.entity().of(ModEntities.FIREFIGHTER.get())))
                    .save(saver, JoJoJetzMod.loc("jojojetz.kill_firefighter"));

            AdvancementHolder getFirefighterHelmet = Advancement.Builder.advancement()
                    .parent(killedFirefighter)
                    .display(
                            ModItems.FIREFIGHTER_HELMET.get(),
                            Component.translatable("advancements.jojojetzmod.firefighter_helmet.title"),
                            Component.translatable("advancements.jojojetzmod.firefighter_helmet.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_firefighter_helmet", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.FIREFIGHTER_HELMET.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.firefighter_helmet"));

            AdvancementHolder getFirefighterPlate = Advancement.Builder.advancement()
                    .parent(killedFirefighter)
                    .display(
                            ModItems.FIREFIGHTER_CHESTPLATE.get(),
                            Component.translatable("advancements.jojojetzmod.firefighter_chestplate.title"),
                            Component.translatable("advancements.jojojetzmod.firefighter_chestplate.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_firefighter_chestplate", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.FIREFIGHTER_CHESTPLATE.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.firefighter_chestplate"));

            AdvancementHolder getFirefighterPants = Advancement.Builder.advancement()
                    .parent(killedFirefighter)
                    .display(
                            ModItems.FIREFIGHTER_LEGGINGS.get(),
                            Component.translatable("advancements.jojojetzmod.firefighter_leggings.title"),
                            Component.translatable("advancements.jojojetzmod.firefighter_leggings.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_firefighter_leggings", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.FIREFIGHTER_LEGGINGS.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.firefighter_leggings"));

            AdvancementHolder getFirefighterBoots = Advancement.Builder.advancement()
                    .parent(killedFirefighter)
                    .display(
                            ModItems.FIREFIGHTER_BOOTS.get(),
                            Component.translatable("advancements.jojojetzmod.firefighter_boots.title"),
                            Component.translatable("advancements.jojojetzmod.firefighter_boots.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_firefighter_boots", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.FIREFIGHTER_BOOTS.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.firefighter_boots"));

            AdvancementHolder getFirefighter = Advancement.Builder.advancement()
                    .parent(killedFirefighter)
                    .display(
                            ModItems.FIREFIGHTER.get(),
                            Component.translatable("advancements.jojojetzmod.firefighter.title"),
                            Component.translatable("advancements.jojojetzmod.firefighter.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_firefighter", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.FIREFIGHTER.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.firefighter"));

            AdvancementHolder getFireTruck = Advancement.Builder.advancement()
                    .parent(killedFirefighter)
                    .display(
                            ModItems.FIRE_TRUCK.get(),
                            Component.translatable("advancements.jojojetzmod.fire_truck.title"),
                            Component.translatable("advancements.jojojetzmod.fire_truck.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_fire_truck", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.FIRE_TRUCK.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.fire_truck"));

            AdvancementHolder getJojoPikmin = Advancement.Builder.advancement()
                    .parent(getHeadband)
                    .display(
                            ModItems.JOJO_PIKMIN.get(),
                            Component.translatable("advancements.jojojetzmod.jojo_pikmin.title"),
                            Component.translatable("advancements.jojojetzmod.jojo_pikmin.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_jojo_pikmin", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.JOJO_PIKMIN.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.jojo_pikmin"));

            AdvancementHolder getFedora = Advancement.Builder.advancement()
                    .parent(getHeadband)
                    .display(
                            ModItems.FEDORA.get(),
                            Component.translatable("advancements.jojojetzmod.fedora.title"),
                            Component.translatable("advancements.jojojetzmod.fedora.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_fedora", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.FEDORA.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.fedora"));

            AdvancementHolder getJetzCultMusicDisc = Advancement.Builder.advancement()
                    .parent(getHeadband)
                    .display(
                            ModItems.JETZ_CULT_MUSIC_DISC.get(),
                            Component.translatable("advancements.jojojetzmod.jetz_cult_music_disc.title"),
                            Component.translatable("advancements.jojojetzmod.jetz_cult_music_disc.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_jetz_cult_music_disc", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.JETZ_CULT_MUSIC_DISC.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.jetz_cult_music_disc"));

            AdvancementHolder getSoundOfMusicDiscs = Advancement.Builder.advancement()
                    .parent(getJetzCultMusicDisc)
                    .display(
                            ModItems.JETZ_CULT_MUSIC_DISC.get(),
                            Component.translatable("advancements.jojojetzmod.jojojetzmod_music_discs.title"),
                            Component.translatable("advancements.jojojetzmod.jojojetzmod_music_discs.description"),
                            null,
                            AdvancementType.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_true_sound_of_music_discs", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.JETZ_CULT_MUSIC_DISC.get(),
                                    ModItems.JETZ_CLUB_MUSIC_DISC.get(),
                                    ModItems.CRAZY_MUSIC_DISC.get(),
                                    ModItems.JEBAITED_MUSIC_DISC.get(),
                                    ModItems.JETZ_CULT_GIRLS_MUSIC_DISC.get(),
                                    ModItems.JOJO_STAMINA_MUSIC_DISC.get(),
                                    ModItems.KITTY_KITTY_MUSIC_DISC.get(),
                                    ModItems.OLD_ZELDA_MUSIC_DISC.get(),
                                    ModItems.TROLOL_MUSIC_DISC.get(),
                                    ModItems.YES_GLENN_MUSIC_DISC.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.jojojetzmod_music_discs"));

            AdvancementHolder killedJojojetz = Advancement.Builder.advancement()
                    .parent(getHeadband)
                    .display(
                            ModItems.JOJOJETZ.get(),
                            Component.translatable("advancements.jojojetzmod.kill_jojojetz.title"),
                            Component.translatable("advancements.jojojetzmod.kill_jojojetz.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("killed_jojojetz", KilledTrigger.TriggerInstance
                            .playerKilledEntity(EntityPredicate.Builder.entity().of(ModEntities.JOJOJETZ.get())))
                    .save(saver, JoJoJetzMod.loc("jojojetz.kill_jojojetz"));

            AdvancementHolder getOldMan = Advancement.Builder.advancement()
                    .parent(getHeadband)
                    .display(
                            ModItems.OLD_MAN.get(),
                            Component.translatable("advancements.jojojetzmod.old_man.title"),
                            Component.translatable("advancements.jojojetzmod.old_man.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_old_man", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.OLD_MAN.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.old_man"));

            AdvancementHolder killedJojoLink = Advancement.Builder.advancement()
                    .parent(getHeadband)
                    .display(
                            ModItems.JOJO_LINK.get(),
                            Component.translatable("advancements.jojojetzmod.kill_jojo_link.title"),
                            Component.translatable("advancements.jojojetzmod.kill_jojo_link.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("killed_jojo_link", KilledTrigger.TriggerInstance
                            .playerKilledEntity(EntityPredicate.Builder.entity().of(ModEntities.JOJO_LINK.get())))
                    .save(saver, JoJoJetzMod.loc("jojojetz.kill_jojo_link"));

            AdvancementHolder getLexiGun = Advancement.Builder.advancement()
                    .parent(getHeadband)
                    .display(
                            ModItems.LEXI_GUN.get(),
                            Component.translatable("advancements.jojojetzmod.lexi_gun.title"),
                            Component.translatable("advancements.jojojetzmod.lexi_gun.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_lexi_gun", InventoryChangeTrigger.TriggerInstance
                            .hasItems(ModItems.LEXI_GUN.get()))
                    .save(saver, JoJoJetzMod.loc("jojojetz.lexi_gun"));
        }
    }
}
