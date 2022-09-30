package net.mcreator.dhelp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dhelp.network.DhelpModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DeathcordsProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			DhelpModVariables.MapVariables.get(world).x = Math.round(entity.getX());
			DhelpModVariables.MapVariables.get(world).syncData(world);
			DhelpModVariables.MapVariables.get(world).y = Math.round(entity.getY());
			DhelpModVariables.MapVariables.get(world).syncData(world);
			DhelpModVariables.MapVariables.get(world).z = Math.round(entity.getZ());
			DhelpModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
