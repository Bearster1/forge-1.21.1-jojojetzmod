package net.bearster.jojojetzmod.mixin;

import net.bearster.jojojetzmod.JoJoJetzMod;
import net.bearster.jojojetzmod.entity.client.ModCatVariants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.CatVariant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CatVariant.class)
public abstract class CatVariantMixin {

    @Inject(method = "bootstrap", at = @At("HEAD"))
    private static void bootstrap(Registry<CatVariant> pRegistry, CallbackInfoReturnable<CatVariant> cir) {
        newRegister(pRegistry, ModCatVariants.DISCO, "textures/entity/cat/disco.png");
        newRegister(pRegistry, ModCatVariants.DAVIE, "textures/entity/cat/davie.png");
        newRegister(pRegistry, ModCatVariants.ARCHIE, "textures/entity/cat/archie.png");
    }

    @Unique
    private static CatVariant newRegister(Registry<CatVariant> pRegistry, ResourceKey<CatVariant> pKey, String pTexture) {
        return Registry.register(pRegistry, pKey, new CatVariant(JoJoJetzMod.loc(pTexture)));
    }

}
