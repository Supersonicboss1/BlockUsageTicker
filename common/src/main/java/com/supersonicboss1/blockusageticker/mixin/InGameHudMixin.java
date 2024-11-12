package com.supersonicboss1.blockusageticker.mixin;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.Gui;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Gui.class})
public abstract class InGameHudMixin extends GuiComponent {
    @Shadow
    private int screenHeight;
    @Shadow
    private int screenWidth;

    public InGameHudMixin() {
    }

    @Shadow
    protected abstract Player getCameraPlayer();

    @Shadow
    protected abstract void renderSlot(int var1, int var2, float var3, Player var4, ItemStack var5, int var6);

    @Inject(
            method = {"renderHotbar"},
            at = {@At("TAIL")}
    )
    private void renderHotbar(float tickDelta, PoseStack matrices, CallbackInfo ci) {
        Player playerEntity = this.getCameraPlayer();
        ItemStack itemStack = playerEntity.getMainHandItem();
        ItemStack itemStackOffhand = playerEntity.getOffhandItem();
        if (!itemStack.isEmpty()) {
            int itemTotal = playerEntity.getInventory().countItem(itemStack.getItem());
            ItemStack newStack = new ItemStack(itemStack.getItem(), itemTotal);
            // only render if held stack count == total in inventory
            if (itemTotal != itemStack.getCount()) {
            if (itemStackOffhand.isEmpty()) {
                this.renderSlot(this.screenWidth / 2 - 91 - 22, this.screenHeight - 20, tickDelta, playerEntity, newStack, 0);
            } else {
                this.renderSlot(this.screenWidth / 2 + 91 + 6, this.screenHeight - 20, tickDelta, playerEntity, newStack, 0);
            }}
        }
    }
}