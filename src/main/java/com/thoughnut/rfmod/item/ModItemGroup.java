package com.thoughnut.rfmod.item;

import com.thoughnut.rfmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup RF_GROUP = new ItemGroup("RFModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.RF_ORE.get());
        }


    };
}
