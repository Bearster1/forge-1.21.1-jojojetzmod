package net.bearster.jojojetzmod.item;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.item.custom.*;
import net.bearster.jojojetzmod.item.custom.armor.ArmorModel;
import net.bearster.jojojetzmod.item.custom.armor.ArmorRenderer;
import net.bearster.jojojetzmod.item.custom.armor.BasicArmorItem;
import net.bearster.jojojetzmod.item.custom.armor.fedora.client.model.FedoraArmorModel;
import net.bearster.jojojetzmod.item.custom.armor.firefighter.client.model.FirefighterArmorModel;
import net.bearster.jojojetzmod.item.custom.armor.headband.HeadbandArmorItem;
import net.bearster.jojojetzmod.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JoJoJetzMod.MOD_ID);

    public static final RegistryObject<Item> BURRITO = ITEMS.register("burrito",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BURRITO)));

    public static final RegistryObject<Item> SPARKLING_WATER = ITEMS.register("sparkling_water",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SPARKLING_WATER)) {
                @Override
                public UseAnim getUseAnimation(ItemStack pStack) {
                    return UseAnim.DRINK;
                }
            });

    public static final RegistryObject<Item> JETZ_JUICE = ITEMS.register("jetz_juice",
            () -> new Item(new Item.Properties().food(ModFoodProperties.JETZ_JUICE)) {
                @Override
                public UseAnim getUseAnimation(ItemStack pStack) {
                    return UseAnim.DRINK;
                }
            });

    public static final RegistryObject<Item> HEADBAND = ITEMS.register("headband",
            () -> new HeadbandArmorItem(ModArmorMaterials.HEADBAND_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50))));

    public static final RegistryObject<Item> FEDORA = ITEMS.register("fedora",
            () -> new BasicArmorItem(ModArmorMaterials.FEDORA_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50)), "fedora_armor") {

                @Override
                protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
                    return new ArmorRenderer<ArmorModel>(FedoraArmorModel::createBodyLayer, FedoraArmorModel::new);
                }
            });

    public static final RegistryObject<Item> FIREFIGHTER_HELMET = ITEMS.register("firefighter_helmet",
            () -> new BasicArmorItem(ModArmorMaterials.FIREFIGHTER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50)), "firefighter_armor") {

                @Override
                protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
                    return new ArmorRenderer<ArmorModel>(FirefighterArmorModel::createBodyLayer, FirefighterArmorModel::new);
                }
            });

    public static final RegistryObject<Item> FIREFIGHTER_CHESTPLATE = ITEMS.register("firefighter_chestplate",
            () -> new BasicArmorItem(ModArmorMaterials.FIREFIGHTER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), "firefighter_armor") {

                @Override
                protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
                    return new ArmorRenderer<ArmorModel>(FirefighterArmorModel::createBodyLayer, FirefighterArmorModel::new);
                }
            });

    public static final RegistryObject<Item> FIREFIGHTER_LEGGINGS = ITEMS.register("firefighter_leggings",
            () -> new BasicArmorItem(ModArmorMaterials.FIREFIGHTER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "firefighter_armor") {

                @Override
                protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
                    return new ArmorRenderer<ArmorModel>(FirefighterArmorModel::createBodyLayer, FirefighterArmorModel::new);
                }
            });

    public static final RegistryObject<Item> FIREFIGHTER_BOOTS = ITEMS.register("firefighter_boots",
            () -> new BasicArmorItem(ModArmorMaterials.FIREFIGHTER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(50)), "firefighter_armor") {

                @Override
                protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
                    return new ArmorRenderer<ArmorModel>(FirefighterArmorModel::createBodyLayer, FirefighterArmorModel::new);
                }
            });

    public static final RegistryObject<Item> CRAZY_MUSIC_DISC = ITEMS.register("crazy_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.CRAZY_KEY)));

    public static final RegistryObject<Item> JEBAITED_MUSIC_DISC = ITEMS.register("jebaited_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.JEBAITED_KEY)));

    public static final RegistryObject<Item> JETZ_CULT_GIRLS_MUSIC_DISC = ITEMS.register("jetz_cult_girls_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.JETZ_CULT_GIRLS_KEY)));

    public static final RegistryObject<Item> JOJO_STAMINA_MUSIC_DISC = ITEMS.register("jojo_stamina_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.JOJO_STAMINA_KEY)));

    public static final RegistryObject<Item> KITTY_KITTY_MUSIC_DISC = ITEMS.register("kitty_kitty_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.KITTY_KITTY_KEY)));

    public static final RegistryObject<Item> OLD_ZELDA_MUSIC_DISC = ITEMS.register("old_zelda_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.OLD_ZELDA_KEY)));

    public static final RegistryObject<Item> TROLOL_MUSIC_DISC = ITEMS.register("trolol_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.TROLOL_KEY)));

    public static final RegistryObject<Item> JETZ_CULT_MUSIC_DISC = ITEMS.register("jetz_cult_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.JETZ_CULT_KEY)));

    public static final RegistryObject<Item> JETZ_CLUB_MUSIC_DISC = ITEMS.register("jetz_club_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.JETZ_CLUB_KEY)));

    public static final RegistryObject<Item> YES_GLENN_MUSIC_DISC = ITEMS.register("yes_glenn_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.YES_GLENN_KEY)));

    public static final RegistryObject<Item> CHAIRCHAIRJETZ = ITEMS.register("chairchairjetz",
            () -> new SpawnEggCustomTextureItem(ModEntities.CHAIRCHAIRJETZ, new Item.Properties()));

    public static final RegistryObject<Item> FIREFIGHTER = ITEMS.register("firefighter",
            () -> new SpawnEggCustomTextureItem(ModEntities.FIREFIGHTER, new Item.Properties()));

    public static final RegistryObject<Item> FIRE_TRUCK = ITEMS.register("fire_truck",
            () -> new SpawnEggCustomTextureItem(ModEntities.FIRE_TRUCK, new Item.Properties()));

    public static final RegistryObject<Item> GOOSE = ITEMS.register("goose",
            () -> new SpawnEggCustomTextureItem(ModEntities.GOOSE, new Item.Properties()));

    public static final RegistryObject<Item> OLD_MAN = ITEMS.register("old_man",
            () -> new SpawnEggCustomTextureItem(ModEntities.OLD_MAN, new Item.Properties()));

    public static final RegistryObject<Item> JOJO_LINK = ITEMS.register("jojo_link",
            () -> new SpawnEggCustomTextureItem(ModEntities.JOJO_LINK, new Item.Properties()));

    public static final RegistryObject<Item> JOJO_PIKMIN = ITEMS.register("jojo_pikmin",
            () -> new JoJoPikminItem(new Item.Properties()));

    public static final RegistryObject<Item> JOJOJETZ = ITEMS.register("jojojetz",
            () -> new SpawnEggCustomTextureItem(ModEntities.JOJOJETZ, new Item.Properties()));

    public static final RegistryObject<Item> GK_LIGHTSABER = ITEMS.register("gk_lightsaber",
            () -> new SwordItem(Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.DIAMOND,6,0f))));

    public static final RegistryObject<Item> PENCIL = ITEMS.register("pencil",
            () -> new SwordItem(Tiers.WOOD, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD,4,-3f))));

    public static final RegistryObject<Item> PLUNGER = ITEMS.register("plunger",
            () -> new SwordItem(Tiers.IRON, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON,1,-2f))));

    public static final RegistryObject<Item> MILK_BOTTLE = ITEMS.register("milk_bottle",
            () -> new Item(new Item.Properties().food(ModFoodProperties.MILK_BOTTLE)) {
                @Override
                @Nonnull
                public UseAnim getUseAnimation(ItemStack pStack) {
                    return UseAnim.DRINK;
                }


            });

    public static final RegistryObject<Item> LEXI_GUN = ITEMS.register("lexi_gun",
            () -> new LexiGunItem(new Item.Properties().durability(1000)));

    public static final RegistryObject<Item> LEXI_BULLET = ITEMS.register("lexi_bullet",
            () -> new LexiBulletItem(new Item.Properties().stacksTo(64).fireResistant()));

    public static final RegistryObject<Item> LEXI_MAG = ITEMS.register("lexi_mag",
            () -> new LexiMagItem(new Item.Properties().stacksTo(1).fireResistant()) {
                @Override
                public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
                    return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
                }
            });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
