package com.thoughnut.rfmod.item;

import com.thoughnut.rfmod.RFMod;
import com.thoughnut.rfmod.block.ModBlocks;
import com.thoughnut.rfmod.entity.ModEntityTypes;
import com.thoughnut.rfmod.item.custom.ModArmorMaterial;
import com.thoughnut.rfmod.item.custom.ModSpawnEgg;
import com.thoughnut.rfmod.item.custom.RFIngot;
import com.thoughnut.rfmod.item.custom.Tosti;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RFMod.MOD_ID);

    //items
    public static final RegistryObject<Item> TOSTI = ITEMS.register("tosti",
            () -> new Tosti(new Item.Properties().group(ModItemGroup.RF_GROUP)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 200, 3), 1.0f).hunger(8).saturation(0.6f).build())));
    public static final RegistryObject<Item> KAAS = ITEMS.register("kaas",
            () -> new Item(new Item.Properties().group(ModItemGroup.RF_GROUP)
                    .food(new Food.Builder().hunger(4).saturation(0.1f).build())));
    public static final RegistryObject<Item> BROODJEHAMKAAS = ITEMS.register("broodjehamkaas",
            () -> new Item(new Item.Properties().group(ModItemGroup.RF_GROUP)
                    .food(new Food.Builder().hunger(6).saturation(0.2f).build())));
    public static final RegistryObject<Item> GROUND_BEEF = ITEMS.register("ground_beef",
            () -> new Item(new Item.Properties().group(ModItemGroup.RF_GROUP)
                    .food(new Food.Builder().hunger(2).saturation(2f)
                            .effect(() -> new EffectInstance(Effects.POISON, 400, 2), 1.0f)
                            .effect(() -> new EffectInstance(Effects.NAUSEA, 400, 10), 1.0f).build())));

    //materials
    public static final RegistryObject<Item> RFINGOT = ITEMS.register("rf_ingot",
            () -> new RFIngot(new Item.Properties().group(ModItemGroup.RF_GROUP)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.NAUSEA, 300, 4), 0.9f)
                            .hunger(1).saturation(0.1f).build())));

    //tools
    public static final RegistryObject<Item> RF_SWORD = ITEMS.register("rf_sword",
            () -> new SwordItem(ModItemTier.RF, 4, -2f, new Item.Properties().group(ModItemGroup.RF_GROUP)));
    public static final RegistryObject<Item> RF_PICKAXE = ITEMS.register("rf_pickaxe",
            () -> new PickaxeItem(ModItemTier.RF, 1, -3f, new Item.Properties().group(ModItemGroup.RF_GROUP)));
    public static final RegistryObject<Item> RF_SHOVEL = ITEMS.register("rf_shovel",
            () -> new ShovelItem(ModItemTier.RF, 2, -3f, new Item.Properties().group(ModItemGroup.RF_GROUP)));
    public static final RegistryObject<Item> RF_AXE = ITEMS.register("rf_axe",
            () -> new AxeItem(ModItemTier.RF, 5, -3.5f, new Item.Properties().group(ModItemGroup.RF_GROUP)));
    public static final RegistryObject<Item> RF_HOE = ITEMS.register("rf_hoe",
            () -> new HoeItem(ModItemTier.RF, 1, -1f, new Item.Properties().group(ModItemGroup.RF_GROUP)));

    //armor
    public static final RegistryObject<Item> RF_BOOTS = ITEMS.register("rf_boots",
            () -> new ArmorItem(ModArmorMaterial.RF, EquipmentSlotType.FEET,  new Item.Properties().group(ModItemGroup.RF_GROUP)));
    public static final RegistryObject<Item> RF_LEGGINGS = ITEMS.register("rf_leggings",
            () -> new ArmorItem(ModArmorMaterial.RF, EquipmentSlotType.LEGS, new Item.Properties().group(ModItemGroup.RF_GROUP)));
    public static final RegistryObject<Item> RF_CHESTPLATE = ITEMS.register("rf_chestplate",
            () -> new ArmorItem(ModArmorMaterial.RF, EquipmentSlotType.CHEST,  new Item.Properties().group(ModItemGroup.RF_GROUP)));
    public static final RegistryObject<Item> RF_HELMET = ITEMS.register("rf_helmet",
            () -> new ArmorItem(ModArmorMaterial.RF, EquipmentSlotType.HEAD,  new Item.Properties().group(ModItemGroup.RF_GROUP)));

    //spawn eggs
    public static final RegistryObject<ModSpawnEgg> AD_LOOIJ_SPAWN_EGG = ITEMS.register("ad_looij_spawn_egg",
            () -> new ModSpawnEgg(ModEntityTypes.AD_LOOIJ, 0xb4c064, 0x8c6d6e
                    , new Item.Properties().group(ModItemGroup.RF_GROUP)));

    //crops
    public static final RegistryObject<Item> ONIONS = ITEMS.register("onions",
            () -> new BlockItem(ModBlocks.ONION.get(),  new Item.Properties().food(new Food.Builder().hunger(1)
                    .saturation(0.4f).fastToEat().build()).group(ModItemGroup.RF_GROUP)));
    public static final RegistryObject<Item> LEEKS = ITEMS.register("leeks",
            () -> new BlockItem(ModBlocks.LEEK.get(),  new Item.Properties().food(new Food.Builder().hunger(2)
                    .saturation(1f).build()).group(ModItemGroup.RF_GROUP)));

    public static final RegistryObject<Item> BEEF_TOMATOES = ITEMS.register("beef_tomatoes",
            () -> new BlockItem(ModBlocks.BEEF_TOMATO.get(),  new Item.Properties().food(new Food.Builder().hunger(2)
                    .saturation(1.5f).build()).group(ModItemGroup.RF_GROUP)));



    public static void registry(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
