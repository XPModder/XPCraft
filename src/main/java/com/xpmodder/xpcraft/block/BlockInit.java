package com.xpmodder.xpcraft.block;

import com.xpmodder.xpcraft.Util.Reference;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MODID);

    public static final RegistryObject<Block> XPCOLLECTOR = BLOCKS.register("xp_collector", () ->
            new XPCollectorBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

}
