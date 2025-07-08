package net.bearster.jojojetzmod.item;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials extends ArmorMaterials {
    public static final Holder<ArmorMaterial> HEADBAND_ARMOR_MATERIAL = register(
            "headband",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 10);
                attribute.put(ArmorItem.Type.CHESTPLATE, 10);
                attribute.put(ArmorItem.Type.HELMET, 7);
                attribute.put(ArmorItem.Type.BODY, 15);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.of(Items.STRING),
            List.of(
                    new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID,"headband"), "", true)
            )
    );

    public static final Holder<ArmorMaterial> FEDORA_ARMOR_MATERIAL = register(
            "fedora",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 10);
                attribute.put(ArmorItem.Type.CHESTPLATE, 10);
                attribute.put(ArmorItem.Type.HELMET, 7);
                attribute.put(ArmorItem.Type.BODY, 15);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.of(Items.LEATHER),
            List.of(
                    new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID,"fedora"), "", false)
            )
    );

    public static final Holder<ArmorMaterial> FIREFIGHTER_ARMOR_MATERIAL = register(
            "firefighter",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 15);
                attribute.put(ArmorItem.Type.LEGGINGS, 15);
                attribute.put(ArmorItem.Type.CHESTPLATE, 15);
                attribute.put(ArmorItem.Type.HELMET, 15);
                attribute.put(ArmorItem.Type.BODY, 60);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            1.0F,
            () -> Ingredient.of(Items.IRON_BLOCK),
            List.of(
                    new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID,"firefighter"), "", false)
            )
    );

    public static Holder<ArmorMaterial> bootstrap(Registry<ArmorMaterial> pRegistry) {
        return HEADBAND_ARMOR_MATERIAL;
    }





    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }

    private static Holder<ArmorMaterial> register(
            String pName,
            EnumMap<ArmorItem.Type, Integer> pDefense,
            int pEnchantmentValue,
            Holder<SoundEvent> pEquipSound,
            float pToughness,
            float pKnockbackResistance,
            Supplier<Ingredient> pRepairIngridient,
            List<ArmorMaterial.Layer> pLayers
    ) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
            enummap.put(armoritem$type, pDefense.get(armoritem$type));
        }

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                ResourceLocation.withDefaultNamespace(pName),
                new ArmorMaterial(enummap, pEnchantmentValue, pEquipSound, pRepairIngridient, pLayers, pToughness, pKnockbackResistance)
        );
    }
}