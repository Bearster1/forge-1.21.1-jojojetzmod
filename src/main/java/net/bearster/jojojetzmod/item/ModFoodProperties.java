package net.bearster.jojojetzmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties BURRITO = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1.5f).build();
    public static final FoodProperties SPARKLING_WATER = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(3.75f).build();
    public static final FoodProperties JETZ_JUICE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(5f).build();
    public static final FoodProperties MILK_BOTTLE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(1f)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();
}
