
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dhelp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.dhelp.DhelpMod;

public class DhelpModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DhelpMod.MODID);
	public static final RegistryObject<ParticleType<?>> DEATHFINDPARTICLE = REGISTRY.register("deathfindparticle",
			() -> new SimpleParticleType(true));
}
