package net.bearster.jojojetzmod;

import com.mojang.logging.LogUtils;
import net.bearster.jojojetzmod.block.ModBlocks;
import net.bearster.jojojetzmod.entity.ModEntities;
import net.bearster.jojojetzmod.entity.client.*;
import net.bearster.jojojetzmod.item.ModCreativeModeTabs;
import net.bearster.jojojetzmod.item.ModItems;
import net.bearster.jojojetzmod.item.custom.armor.headband.HeadbandArmorItem;
import net.bearster.jojojetzmod.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import javax.swing.text.html.parser.Entity;

/**
 * J0J0Jetz Cult(ure) Club Mod
 */
// The value here should match an entry in the META-INF/mods.toml file
@Mod(JoJoJetzMod.MOD_ID)
public class JoJoJetzMod
{
    // Define mod id in a common place for everything to reference
    /**
     * Mod ID
     */
    public static final String MOD_ID = "jojojetzmod";

    // Directly reference a slf4j logger
    /**
     * Global Logger
     */
    public static final Logger LOGGER = LogUtils.getLogger();

    /** Locates a resource by ID
     * @param id Identifier to locate
     * @return The Resource Location
     */
    public static ResourceLocation loc(final String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }


    /** Constructs the J0J0Jetz Mod
     * @param context Forge Mod Loader Context
     */
    public JoJoJetzMod(final FMLJavaModLoadingContext context) {

        final IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);


        ModEntities.register(modEventBus);

        ModSounds.SOUND_EVENTS.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {}

    // Add the example block item to the building blocks tab
    private void addCreative(final BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(final ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = JoJoJetzMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            final ItemColors itemColors = Minecraft.getInstance().getItemColors();

            itemColors.register((stack, tintIndex) -> {
                if (0 == tintIndex) {
                    final int color = ((HeadbandArmorItem) stack.getItem()).getColor(stack);
                    // JoJoJetzMod.LOGGER.info("TintIndex 0 color: {}", Integer.toHexString(color));

                    return color | (255 << 24);
                }
                // JoJoJetzMod.LOGGER.info("TintIndex {} returning -1", tintIndex);
                return -1;
            }, ModItems.HEADBAND.get());

            EntityRenderers.register(ModEntities.CHAIRCHAIRJETZ.get(), ChairChairJetzRenderer::new);
            EntityRenderers.register(ModEntities.FIREFIGHTER.get(), FirefighterRenderer::new);
            EntityRenderers.register(ModEntities.FIRE_TRUCK.get(), FireTruckRenderer::new);
            EntityRenderers.register(ModEntities.GOOSE.get(), GooseRenderer::new);
            EntityRenderers.register(ModEntities.OLD_MAN.get(), OldManRenderer::new);
            EntityRenderers.register(ModEntities.JOJO_LINK.get(), JoJoLinkRenderer::new);
            EntityRenderers.register(ModEntities.JOJO_PIKMIN.get(), JoJoPikminRenderer::new);
            EntityRenderers.register(ModEntities.JOJO_PIKMIN_PROJECTILE.get(), JoJoPikminProjectileRenderer::new);
            EntityRenderers.register(ModEntities.JOJOJETZ.get(), JoJoJetzRenderer::new);
            EntityRenderers.register(ModEntities.LEXI_BULLET_PROJECTILE.get(), LexiBulletRenderer::new);
        }

    }
}
