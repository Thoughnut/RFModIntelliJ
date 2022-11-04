package com.thoughnut.rfmod.tileentity;

import com.thoughnut.rfmod.RFMod;
import com.thoughnut.rfmod.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntitities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RFMod.MOD_ID);


    public static RegistryObject<TileEntityType<MeatGrinderTile>> MEAT_GRINDER_TILE = TILE_ENTITIES.register("meat_grinder_tile"
            , () -> TileEntityType.Builder.create(MeatGrinderTile::new, ModBlocks.ADLOOIJGRINDER.get()).build(null));
    public static void register(IEventBus eventBus){
        TILE_ENTITIES.register(eventBus);
    }
}
