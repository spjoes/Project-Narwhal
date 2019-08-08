package com.DU.ProjectNarwhal.init;

import com.DU.ProjectNarwhal.block.*;
import com.DU.ProjectNarwhal.ProjectNarwhal;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;

import static io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils.register;

public class PNarwhalBlocks {


    public static final Block TLAMPS;
    public static final Block SNES;

    static {
        TLAMPS = register(new BlockThrowableLamps(Material.ANVIL), new Identifier(ProjectNarwhal.MOD_ID, "tlamps"));
        SNES = register(new BlockSnes(Material.ANVIL), new Identifier(ProjectNarwhal.MOD_ID, "snes"));
    }

    private static Block registerDevice(Block block, Identifier name) {
        return RegistryUtils.register(block, name, ProjectNarwhal.PNARWHAL_TAB);
    }

    private static Block register(Block block, Identifier name) {
        return RegistryUtils.register(block, name, ProjectNarwhal.PNARWHAL_TAB);
    }

}