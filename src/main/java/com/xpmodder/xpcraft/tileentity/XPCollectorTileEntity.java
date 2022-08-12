package com.xpmodder.xpcraft.tileentity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class XPCollectorTileEntity extends BlockEntity {

    private float collectedXP = 0;

    public XPCollectorTileEntity(BlockPos pos, BlockState state) {
        super(TileInit.XPCOLLECTOR.get(), pos, state);
    }


    public float getCollectedXP(){
        return this.collectedXP;
    }


    public static void tick(Level level, BlockPos pos, BlockState state, XPCollectorTileEntity self){

        self.collectedXP = 0;

        for(int x = pos.getX()-5; x < pos.getX()+6; x++){
            for(int y = pos.getY()-5; y < pos.getY()+6; y++){
                for(int z = pos.getZ()-5; z < pos.getZ()+6; z++){

                    BlockState blockState = level.getBlockState(new BlockPos(x, y, z));

                    if(blockState.getBlock() instanceof FlowerBlock){
                        self.collectedXP += 0.1;
                    }
                    else if(blockState.getBlock() instanceof LeavesBlock){
                        if(!blockState.getValue(BlockStateProperties.PERSISTENT)){
                            self.collectedXP += 1;
                        }
                    }
                    else if(blockState.getBlock() instanceof CropBlock || blockState.getBlock() instanceof StemBlock){
                        self.collectedXP += (-1 * (blockState.getValue(BlockStateProperties.AGE_7) - 8));
                    }
                    else if(blockState.getBlock() instanceof AttachedStemBlock){
                        self.collectedXP += 0.5;
                    }
                    else if(blockState.getBlock() instanceof CactusBlock || blockState.getBlock() instanceof SugarCaneBlock){
                        self.collectedXP += 1.5;
                    }
                    else if(blockState.getBlock() instanceof SaplingBlock){
                        self.collectedXP += 2;
                    }
                    else if(blockState.getBlock() instanceof VineBlock || blockState.getBlock() instanceof GrowingPlantBlock){
                        self.collectedXP += 1.2;
                    }


                }
            }
        }

    }


}
