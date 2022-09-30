
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dhelp.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.dhelp.network.TogglehelpMessage;
import net.mcreator.dhelp.DhelpMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DhelpModKeyMappings {
	public static final KeyMapping TOGGLEHELP = new KeyMapping("key.dhelp.togglehelp", GLFW.GLFW_KEY_R, "key.categories.misc");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(TOGGLEHELP);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == TOGGLEHELP.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						DhelpMod.PACKET_HANDLER.sendToServer(new TogglehelpMessage(0, 0));
						TogglehelpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
