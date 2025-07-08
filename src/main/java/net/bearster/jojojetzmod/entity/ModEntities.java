package net.bearster.jojojetzmod.entity;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, JoJoJetzMod.MOD_ID);

    public static final RegistryObject<EntityType<ChairChairJetzEntity>> CHAIRCHAIRJETZ =
            ENTITY_TYPES.register("chairchairjetz", () -> EntityType.Builder.of(ChairChairJetzEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 2f).build("chairchairjetz"));

    public static final RegistryObject<EntityType<FirefighterEntity>> FIREFIGHTER =
            ENTITY_TYPES.register("firefighter", () -> EntityType.Builder.of(FirefighterEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 1.8f).build("firefighter"));

    public static final RegistryObject<EntityType<FireTruckEntity>> FIRE_TRUCK =
            ENTITY_TYPES.register("fire_truck", () -> EntityType.Builder.of(FireTruckEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.55f).build("fire_truck"));

    public static final RegistryObject<EntityType<GooseEntity>> GOOSE =
            ENTITY_TYPES.register("goose", () -> EntityType.Builder.of(GooseEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 1.4f).build("goose"));

    public static final RegistryObject<EntityType<OldManEntity>> OLD_MAN =
            ENTITY_TYPES.register("old_man", () -> EntityType.Builder.of(OldManEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("old_man"));

    public static final RegistryObject<EntityType<JoJoLinkEntity>> JOJO_LINK =
            ENTITY_TYPES.register("jojo_link", () -> EntityType.Builder.of(JoJoLinkEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 1.5f).build("jojo_link"));

    public static final RegistryObject<EntityType<JoJoPikminEntity>> JOJO_PIKMIN =
            ENTITY_TYPES.register("jojo_pikmin", () -> EntityType.Builder.of(JoJoPikminEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 1.15f).build("jojo_pikmin"));

    public static final RegistryObject<EntityType<JoJoPikminProjectileEntity>> JOJO_PIKMIN_PROJECTILE =
            ENTITY_TYPES.register("jojo_pikmin_projectile", () -> EntityType.Builder.<JoJoPikminProjectileEntity>of(JoJoPikminProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("jojo_pikmin_projectile"));

    public static final RegistryObject<EntityType<JoJoJetzEntity>> JOJOJETZ =
            ENTITY_TYPES.register("jojojetz", () -> EntityType.Builder.of(JoJoJetzEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 1.5f).build("jojojetz"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
