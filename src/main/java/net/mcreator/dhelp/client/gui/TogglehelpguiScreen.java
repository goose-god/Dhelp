
package net.mcreator.dhelp.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.dhelp.world.inventory.TogglehelpguiMenu;
import net.mcreator.dhelp.network.TogglehelpguiButtonMessage;
import net.mcreator.dhelp.DhelpMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class TogglehelpguiScreen extends AbstractContainerScreen<TogglehelpguiMenu> {
	private final static HashMap<String, Object> guistate = TogglehelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public TogglehelpguiScreen(TogglehelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("dhelp:textures/screens/togglehelpgui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Do you want Dhelp on or off?", 9, 9, -12829636);
		this.font.draw(poseStack, "(you can toggle with r if you", 6, 24, -12829636);
		this.font.draw(poseStack, "change your mind!)", 33, 38, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 32, this.topPos + 112, 35, 20, new TextComponent("On"), e -> {
			if (true) {
				DhelpMod.PACKET_HANDLER.sendToServer(new TogglehelpguiButtonMessage(0, x, y, z));
				TogglehelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 103, this.topPos + 112, 40, 20, new TextComponent("Off"), e -> {
			if (true) {
				DhelpMod.PACKET_HANDLER.sendToServer(new TogglehelpguiButtonMessage(1, x, y, z));
				TogglehelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
