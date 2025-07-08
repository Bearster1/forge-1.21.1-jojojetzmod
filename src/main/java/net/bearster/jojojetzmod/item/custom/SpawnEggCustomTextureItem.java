package net.bearster.jojojetzmod.item.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

public class SpawnEggCustomTextureItem extends ForgeSpawnEggItem {
    public SpawnEggCustomTextureItem(Supplier<? extends EntityType<? extends Mob>> type, Properties props) {
        super(type, 0xFFFFFF, 0xFFFFFF, props);
    }

}
