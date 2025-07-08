package net.bearster.jojojetzmod.datagen;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, JoJoJetzMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        sixSidedRotatedBlock(ModBlocks.GAMECUBE.get());
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void sixSidedBlock(Block block) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();

        ModelFile model = models().cube(name,
                modLoc("block/" + name + "_down"),
                modLoc("block/" + name + "_up"),
                modLoc("block/" + name + "_north"),
                modLoc("block/" + name + "_south"),
                modLoc("block/" + name + "_west"),
                modLoc("block/" + name + "_east")
        ).texture("particle", modLoc("block/" + name + "_north"));

        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void sixSidedRotatedBlock(Block block) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();

        ModelFile model = models().cube(name,
                modLoc("block/" + name + "_down"),
                modLoc("block/" + name + "_up"),
                modLoc("block/" + name + "_north"),
                modLoc("block/" + name + "_south"),
                modLoc("block/" + name + "_west"),
                modLoc("block/" + name + "_east")
        ).texture("particle", modLoc("block/" + name + "_north"));

        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                    int yRot = switch (facing) {
                        case SOUTH -> 180;
                        case WEST -> 270;
                        case EAST -> 90;
                        default -> 0;
                    };

                    return ConfiguredModel.builder()
                            .modelFile(model)
                            .rotationY(yRot)
                            .build();
                });

        simpleBlockItem(block, model);
    }


}
