package com.xpmodder.xpcraft.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.xpmodder.xpcraft.Util.LogHelper;
import com.xpmodder.xpcraft.tileentity.XPCollectorTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.DrawSelectionEvent;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientEventHandler {


    @SubscribeEvent
    public static void onHighlightBlock(DrawSelectionEvent.HighlightBlock event){

        Minecraft instance = Minecraft.getInstance();
        Level worldIn = instance.level;
        BlockPos hitPos = event.getTarget().getBlockPos();

        if(worldIn == null || instance.player == null){
            return;
        }

        BlockState state = worldIn.getBlockState(hitPos);

        if(state.hasBlockEntity()){

            if(worldIn.getBlockEntity(hitPos) instanceof XPCollectorTileEntity entity){

                PoseStack matrixStack = event.getPoseStack();

                String text = "Collectable XP: ";
                text += String.format("%.2f", entity.getCollectedXP());

                matrixStack.pushPose();

                Vec3 cameraPosition = event.getCamera().getPosition();

                matrixStack.translate((double)hitPos.getX() - cameraPosition.x, (double)hitPos.getY() - cameraPosition.y, (double)hitPos.getZ() - cameraPosition.z);

                matrixStack.translate(0.5, 1.2, 0.5);

                matrixStack.scale(-0.015F, -0.015F, -0.015F);

                Quaternion rotation = event.getCamera().rotation();

                matrixStack.mulPose(rotation);

                MultiBufferSource bufferSource = event.getMultiBufferSource();

                int packedLight = instance.getEntityRenderDispatcher().getPackedLightCoords(instance.player, event.getPartialTicks());

                float f2 = (float) (-instance.font.width(text) / 2);

                instance.font.drawInBatch(text, f2, 0.1f, 0xFFFFFFFF, false, matrixStack.last().pose(), bufferSource, false, 0, packedLight);

                matrixStack.popPose();

            }

        }

    }

}
