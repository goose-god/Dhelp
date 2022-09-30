
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dhelp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.dhelp.item.DeathfinderItem;
import net.mcreator.dhelp.DhelpMod;

public class DhelpModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DhelpMod.MODID);
	public static final RegistryObject<Item> DEATHFINDER = REGISTRY.register("deathfinder", () -> new DeathfinderItem());
}
