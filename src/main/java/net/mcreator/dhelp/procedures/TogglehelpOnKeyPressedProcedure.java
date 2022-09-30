package net.mcreator.dhelp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.dhelp.network.DhelpModVariables;

public class TogglehelpOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (DhelpModVariables.MapVariables.get(world).helptoggle.contains("true")) {
			DhelpModVariables.MapVariables.get(world).helptoggle = "false";
			DhelpModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "say DHelp has been Turned off");
		} else {
			DhelpModVariables.MapVariables.get(world).helptoggle = "true";
			DhelpModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "say DHelp has been Turned on");
		}
	}
}
