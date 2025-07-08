package net.bearster.jojojetzmod.datagen.loot;


import net.bearster.jojojetzmod.block.ModBlocks;
import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatterns;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ModEntityLootTables extends EntityLootSubProvider {

    public ModEntityLootTables(HolderLookup.Provider pRegistries) {
        super(FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    public void generate() {
        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        HolderLookup.RegistryLookup<BannerPattern> bannerRegistryLookup = this.registries.lookupOrThrow(Registries.BANNER_PATTERN);

        this.add(ModEntities.CHAIRCHAIRJETZ.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.CHAIRCHAIRJETZ.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
        this.add(ModEntities.FIRE_TRUCK.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.FIRE_TRUCK.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
        this.add(ModEntities.FIRE_TRUCK.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.FIRE_TRUCK.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));


        this.add(
                ModEntities.FIREFIGHTER.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER_HELMET.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER_CHESTPLATE.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER_LEGGINGS.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER_BOOTS.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))
        );

        this.add(
                ModEntities.GOOSE.get(),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(
                                                LootItem.lootTableItem(Items.FEATHER)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(
                                                LootItem.lootTableItem(Items.CHICKEN)
                                                        .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))
                                        )
                        ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.BURRITO.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(1.0F, 20.0F))
                                        )
                                )
                        ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.BURRITO.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(1.0F, 20.0F))
                                        )
                                )
                        )
        );

        this.add(ModEntities.OLD_MAN.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.OLD_ZELDA_MUSIC_DISC.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))));
        this.add(ModEntities.JOJO_LINK.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                        .apply(new SetEnchantmentsFunction.Builder()
                                                .withEnchantment(enchantmentRegistryLookup.getOrThrow(Enchantments.SHARPNESS), ConstantValue.exactly(5))
                                                .withEnchantment(enchantmentRegistryLookup.getOrThrow(Enchantments.SWEEPING_EDGE), ConstantValue.exactly(3))
                                                .withEnchantment(enchantmentRegistryLookup.getOrThrow(Enchantments.KNOCKBACK), ConstantValue.exactly(2))
                                                .withEnchantment(enchantmentRegistryLookup.getOrThrow(Enchantments.LOOTING), ConstantValue.exactly(3))
                                                .withEnchantment(enchantmentRegistryLookup.getOrThrow(Enchantments.UNBREAKING), ConstantValue.exactly(3))
                                                .withEnchantment(enchantmentRegistryLookup.getOrThrow(Enchantments.MENDING), ConstantValue.exactly(1)))
                                        .apply(SetNameFunction.setName(Component.translatable("name.jojojetzmod.master_sword"), SetNameFunction.Target.ITEM_NAME))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))

                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.SHIELD)
                                        .apply(SetBannerPatternFunction.setBannerPattern(true)
                                                .addPattern(bannerRegistryLookup.getOrThrow(BannerPatterns.BASE), DyeColor.BLUE)
                                                .addPattern(bannerRegistryLookup.getOrThrow(BannerPatterns.FLOWER), DyeColor.RED)
                                                .addPattern(bannerRegistryLookup.getOrThrow(BannerPatterns.HALF_HORIZONTAL), DyeColor.BLUE)
                                                .addPattern(bannerRegistryLookup.getOrThrow(BannerPatterns.TRIANGLE_TOP), DyeColor.YELLOW)
                                                .addPattern(bannerRegistryLookup.getOrThrow(BannerPatterns.STRIPE_TOP), DyeColor.BLUE)
                                                .addPattern(bannerRegistryLookup.getOrThrow(BannerPatterns.CURLY_BORDER), DyeColor.LIGHT_GRAY))
                                        .apply(SetNameFunction.setName(Component.translatable("name.jojojetzmod.hylian_shield"), SetNameFunction.Target.ITEM_NAME))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))

                                );

        this.add(
                ModEntities.JOJOJETZ.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(
                                        LootItem.lootTableItem(ModItems.BURRITO.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.SPARKLING_WATER.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.JETZ_JUICE.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModBlocks.GAMECUBE.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.HEADBAND.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FEDORA.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER_HELMET.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER_CHESTPLATE.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER_LEGGINGS.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER_BOOTS.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.CHAIRCHAIRJETZ.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIREFIGHTER.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.FIRE_TRUCK.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.GOOSE.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.OLD_MAN.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.JOJO_LINK.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.JOJO_PIKMIN.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.JOJOJETZ.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))

                                .add(
                                        LootItem.lootTableItem(ModItems.JETZ_CULT_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.JETZ_CLUB_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.CRAZY_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.JEBAITED_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.JETZ_CULT_GIRLS_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.JOJO_STAMINA_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.KITTY_KITTY_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.OLD_ZELDA_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.TROLOL_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                                .add(
                                        LootItem.lootTableItem(ModItems.YES_GLENN_MUSIC_DISC.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return Stream.of(
                ModEntities.CHAIRCHAIRJETZ.get(),
                ModEntities.FIRE_TRUCK.get(),
                ModEntities.FIREFIGHTER.get(),
                ModEntities.GOOSE.get(),
                ModEntities.OLD_MAN.get(),
                ModEntities.JOJO_LINK.get(),
                ModEntities.JOJOJETZ.get()
        );
    }
}
