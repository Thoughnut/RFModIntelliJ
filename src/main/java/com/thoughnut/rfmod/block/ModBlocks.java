package com.thoughnut.rfmod.block;

import com.thoughnut.rfmod.RFMod;
import com.thoughnut.rfmod.block.custom.*;
import com.thoughnut.rfmod.item.ModItemGroup;
import com.thoughnut.rfmod.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    //Registry
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, RFMod.MOD_ID);

    public static final RegistryObject<Block> RF_ORE = registerBlock("rf_ore", () -> new RFOre(AbstractBlock.Properties.create(Material.ROCK)
            .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));
    public static final RegistryObject<Block> RF_BLOCK = registerBlock("rf_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON)
            .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));
    public static final RegistryObject<Block> ADLOOIJFORNUIS = registerBlock("adlooijfornuis"
            , () -> new AdLooijFornuisBlock(AbstractBlock.Properties.create(Material.IRON).notSolid()
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3f)));
    public static final RegistryObject<Block> ADLOOIJGRINDER = registerBlock("adlooijgrinder"
            , () -> new AdLooijGrinderBlock(AbstractBlock.Properties.create(Material.IRON).notSolid()
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3f)));

    //crops blocks
    public static final RegistryObject<Block> ONION = BLOCKS.register("onion_crop",() -> new WhiteOnionBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> LEEK = BLOCKS.register("leek_crop",() -> new LeekBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BEEF_TOMATO = BLOCKS.register("beef_tomato_crop",() -> new BeefTomatoBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.RF_GROUP)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
