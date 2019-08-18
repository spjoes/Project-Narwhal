package com.du.projectnarwhal.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BlockTv extends Block {

    public static final EnumProperty<TVChannels> CHANNEL = EnumProperty.<TVChannels>of("channel", TVChannels.class);

    public BlockTv(Material materialIn) {


        super(FabricBlockSettings.of(materialIn).build());
    }

    @Override
    public boolean isOpaque(BlockState blockState_1) {
        return false;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return false;
    }


    @Override
    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
        if (playerEntity_1.isSneaking()) {
            shutdownTV(world_1, blockPos_1);
        } else {
            nextChannel(world_1, blockPos_1);
        }
        return true;
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory) {
        stateFactory.add(CHANNEL);
    }

    private static void shutdownTV(World worldIn, BlockPos pos) {
        updateTV(worldIn, pos, TVChannels.NONE);
    }

    private static void nextChannel(World worldIn, BlockPos pos) {
        int nexttv = worldIn.getBlockState(pos).get(CHANNEL).ordinal() + 1;
        if (nexttv == TVChannels.values().length) {
            nexttv = 1;
        }
        updateTV(worldIn, pos, TVChannels.values()[nexttv]);
    }

    private static void updateTV(World worldIn, BlockPos pos, TVChannels channel) {
        worldIn.setBlockState(pos, worldIn.getBlockState(pos).with(CHANNEL, channel));
        // and we need to find how to rewind the texture
    }


    public static enum TVChannels implements StringIdentifiable {
        NONE,
        AWMAN("awman");

        private String textureName;

        TVChannels() {
            this(null);
        }

        TVChannels(String textureName) {
            this.textureName = textureName;
        }

        public String asString() {
            return this.name().toLowerCase();
        }

        public String getTextureName() {
            return this.textureName;
        }

        public static int count() {
            return values().length;
        }

    }
}