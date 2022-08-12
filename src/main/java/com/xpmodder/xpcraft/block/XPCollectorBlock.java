package com.xpmodder.xpcraft.block;

import com.xpmodder.xpcraft.tileentity.TileInit;
import com.xpmodder.xpcraft.tileentity.XPCollectorTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class XPCollectorBlock extends ModBlock implements EntityBlock {

    public XPCollectorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos blockPos, BlockState state1, boolean p_60519_) {
        super.onRemove(state, level, blockPos, state1, p_60519_);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new XPCollectorTileEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> entityType) {
        return createTickerHelper(entityType, TileInit.XPCOLLECTOR.get(), XPCollectorTileEntity::tick);
    }


}
