package com.thoughnut.rfmod.world;

import com.thoughnut.rfmod.RFMod;
import com.thoughnut.rfmod.world.gen.ModEntityGeneration;
import com.thoughnut.rfmod.world.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RFMod.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        ModOreGeneration.generateOres(event);
        ModEntityGeneration.onEntitySpawn(event);
    }
}
