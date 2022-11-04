package com.thoughnut.rfmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class RFIngot extends Item {
    public RFIngot(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {

        if(Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.rfmod.rf_ingot_shift"));
        }else{
            tooltip.add(new TranslationTextComponent("tooltip.rfmod.rf_ingot"));
        }

        super.addInformation(stack, world, tooltip, flag);
    }
}
