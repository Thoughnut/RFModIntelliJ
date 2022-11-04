package com.thoughnut.rfmod.entity;

import com.thoughnut.rfmod.RFMod;
import com.thoughnut.rfmod.entity.custom.AdLooijEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES= DeferredRegister.create(ForgeRegistries.ENTITIES, RFMod.MOD_ID);


    public static final RegistryObject<EntityType<AdLooijEntity>> AD_LOOIJ =ENTITY_TYPES.register("ad_looij",
            () -> EntityType.Builder.create(AdLooijEntity::new, EntityClassification.MONSTER).size(0.8f,2f)
            .build(new ResourceLocation(RFMod.MOD_ID, "ad_looij").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
