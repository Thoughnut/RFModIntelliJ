package com.thoughnut.rfmod.util;

import com.thoughnut.rfmod.RFMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RFMod.MOD_ID);

    public static final RegistryObject<SoundEvent> AD_STIK_1 = registerSoundEvent("ad_stik_1");
    public static final RegistryObject<SoundEvent> AD_STIK_2 = registerSoundEvent("ad_stik_2");
    public static final RegistryObject<SoundEvent> LOOIJ = registerSoundEvent("looij");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(RFMod.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
