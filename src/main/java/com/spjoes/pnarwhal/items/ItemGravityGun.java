package com.spjoes.pnarwhal.items;

import com.spjoes.pnarwhal.PNarwhal;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGravityGun extends Item {

    public ItemGravityGun() {
        this.setMaxStackSize(1);
        this.setRegistryName("ggun");
        this.setUnlocalizedName("ggun");
    }
    
    
}