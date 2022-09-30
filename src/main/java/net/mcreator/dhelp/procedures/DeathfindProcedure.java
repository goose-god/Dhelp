package net.mcreator.dhelp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.dhelp.network.DhelpModVariables;

public class DeathfindProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("You died at: " + DhelpModVariables.MapVariables.get(world).x + ", "
					+ DhelpModVariables.MapVariables.get(world).y + ", " + DhelpModVariables.MapVariables.get(world).z)), (false));
	}
}
