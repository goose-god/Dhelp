package net.mcreator.dhelp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.dhelp.network.DhelpModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DeathblocktestProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getMaterial() == net.minecraft.world.level.material.Material.LAVA) {
			DhelpModVariables.MapVariables.get(world).deathfluid = "minecraft:lava";
			DhelpModVariables.MapVariables.get(world).syncData(world);
		} else {
			DhelpModVariables.MapVariables.get(world).deathfluid = "not lava";
			DhelpModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
