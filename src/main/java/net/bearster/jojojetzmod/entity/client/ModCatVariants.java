package net.bearster.jojojetzmod.entity.client;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.CatVariant;
import org.spongepowered.asm.mixin.Unique;


public class ModCatVariants {

    public static final ResourceKey<CatVariant> DISCO = createKey("disco");
    public static final ResourceKey<CatVariant> DAVIE = createKey("davie");
    public static final ResourceKey<CatVariant> ARCHIE = createKey("archie");

    private static ResourceKey<CatVariant> createKey(String pName) {
        return ResourceKey.create(Registries.CAT_VARIANT, JoJoJetzMod.loc(pName));
    }

}
