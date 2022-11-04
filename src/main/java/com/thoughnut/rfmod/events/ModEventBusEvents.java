package com.thoughnut.rfmod.events;
import com.thoughnut.rfmod.RFMod;
import com.thoughnut.rfmod.entity.ModEntityTypes;
import com.thoughnut.rfmod.entity.custom.AdLooijEntity;
import com.thoughnut.rfmod.item.custom.ModSpawnEgg;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RFMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.AD_LOOIJ.get(), AdLooijEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEgg.initSpawnEggs();
    }
}

