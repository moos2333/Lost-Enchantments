package com.moos2333.lostenchants.registry;

import com.moos2333.lostenchants.enchantment.EnchantmentExecutioner;
import com.moos2333.lostenchants.enchantment.EnchantmentFreeze;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModEnchantments {
    public static final Enchantment EXECUTIONER = new EnchantmentExecutioner();
    public static final Enchantment FREEZE = new EnchantmentFreeze();

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(
                EXECUTIONER.setRegistryName("executioner"),
                FREEZE.setRegistryName("freeze")
        );
    }
}