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

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JoJoJetzMod.MOD_ID)
public class JoJoJetzMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "jojojetzmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation loc(String id) {
        return ResourceLocation.fromNamespaceAndPath(JoJoJetzMod.MOD_ID, id);
    }


    public JoJoJetzMod(FMLJavaModLoadingContext context)
    {

        IEventBus modEventBus = context.getModEventBus();

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
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {}

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {}

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemColors itemColors = Minecraft.getInstance().getItemColors();

            itemColors.register((stack, tintIndex) -> {
                if (tintIndex == 0) {
                    int color = ((HeadbandArmorItem) stack.getItem()).getColor(stack);
                    LOGGER.info("TintIndex 0 color: " + Integer.toHexString(color));

                    return color | (255 << 24);
                }
                LOGGER.info("TintIndex " + tintIndex + " returning -1");
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

        }

    }


}
