package com.xpmodder.xpcraft.tileentity;

import com.google.common.collect.Sets;
import com.xpmodder.xpcraft.Util.Reference;
import com.xpmodder.xpcraft.block.BlockInit;
import com.xpmodder.xpcraft.block.XPCollectorBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class TileInit {

    public static final DeferredRegister<BlockEntityType<?>> TILEENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Reference.MODID);

    public static final RegistryObject<BlockEntityType<XPCollectorTileEntity>> XPCOLLECTOR = TILEENTITIES.register("xp_collector", () ->
            BlockEntityType.Builder.of(XPCollectorTileEntity::new, BlockInit.XPCOLLECTOR.get()).build(null));



}
