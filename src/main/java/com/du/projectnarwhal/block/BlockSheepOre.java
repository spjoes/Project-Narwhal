package com.du.projectnarwhal.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSheepOre extends OreBlock {

    public BlockSheepOre(Material materialIn) {
        super(FabricBlockSettings.of(materialIn).build());
    }

    String [] sheepcolors = {"sheepEntity_1.setColor(DyeColor.WHITE);", "sheepEntity_1.setColor(DyeColor.RED);", "sheepEntity_1.setColor(DyeColor.BLACK);", "sheepEntity_1.setColor(DyeColor.GRAY);", "sheepEntity_1.setColor(DyeColor.BROWN);", "sheepEntity_1.setColor(DyeColor.PINK);", "sheepEntity_1.setColor(DyeColor.ORANGE);", "sheepEntity_1.setColor(DyeColor.YELLOW);", "sheepEntity_1.setColor(DyeColor.CYAN);", "sheepEntity_1.setColor(DyeColor.BLUE);", "sheepEntity_1.setColor(DyeColor.PURPLE);"};






    public void onStacksDropped(BlockState blockState_1, World world_1, BlockPos blockPos_1, ItemStack itemStack_1) {
        super.onStacksDropped(blockState_1, world_1, blockPos_1, itemStack_1);
        if (!world_1.isClient && world_1.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, itemStack_1) == 0) {
            SheepEntity sheepEntity_1 = (SheepEntity) EntityType.SHEEP.create(world_1);
            sheepEntity_1.setPositionAndAngles((double)blockPos_1.getX() + 0.5D, (double)blockPos_1.getY(), (double)blockPos_1.getZ() + 0.5D, 0.0F, 0.0F);


            sheepEntity_1.playSpawnEffects(); Random r = new Random();
            int result = r.nextInt(DyeColor.values().length);
            DyeColor ColorBeingUsed = DyeColor.WHITE;
            switch (result){
                case 0: ColorBeingUsed = DyeColor.BLACK; break;
                case 1: ColorBeingUsed = DyeColor.BLUE; break;
                case 2: ColorBeingUsed = DyeColor.BROWN; break;
                case 3: ColorBeingUsed = DyeColor.CYAN; break;
                case 4: ColorBeingUsed = DyeColor.GRAY; break;
                case 5: ColorBeingUsed = DyeColor.GREEN; break;
                case 6: ColorBeingUsed = DyeColor.LIGHT_BLUE; break;
                case 7: ColorBeingUsed = DyeColor.LIGHT_GRAY; break;
                case 8: ColorBeingUsed = DyeColor.LIME; break;
                case 9: ColorBeingUsed = DyeColor.MAGENTA; break;
                case 10: ColorBeingUsed = DyeColor.ORANGE; break;
                case 11: ColorBeingUsed = DyeColor.PINK; break;
                case 12: ColorBeingUsed = DyeColor.PURPLE; break;
                case 13: ColorBeingUsed = DyeColor.RED; break;
                case 15: ColorBeingUsed = DyeColor.YELLOW; break;
            }

            sheepEntity_1.setColor(ColorBeingUsed);

            world_1.spawnEntity(sheepEntity_1);

        }

    }

    @Override
    public boolean isOpaque(BlockState blockState_1) {
        return false;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return false;
    }

}