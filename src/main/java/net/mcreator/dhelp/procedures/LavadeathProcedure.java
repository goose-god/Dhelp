package net.mcreator.dhelp.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dhelp.network.DhelpModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LavadeathProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (DhelpModVariables.MapVariables.get(world).gip.contains("true")) {
			if (DhelpModVariables.MapVariables.get(world).deathfluid.contains("not lava")) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.IRON_PICKAXE);
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				DhelpModVariables.MapVariables.get(world).gip = "false";
				DhelpModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
