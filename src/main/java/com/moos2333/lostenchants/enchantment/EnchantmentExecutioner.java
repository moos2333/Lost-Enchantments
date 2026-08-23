package com.moos2333.lostenchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EnumCreatureAttribute;

public class EnchantmentExecutioner extends Enchantment {
    public EnchantmentExecutioner() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND });
        this.setName("lostenchants.executioner");
    }

    @Override
    public int getMinLevel() { return 1; }

    @Override
    public int getMaxLevel() { return 5; }

    @Override
    public int getMinEnchantability(int level) { return 10 + (level - 1) * 8; }

    @Override
    public int getMaxEnchantability(int level) { return getMinEnchantability(level) + 20; }

    @Override
    public boolean isTreasureEnchantment() { return true; }

    @Override
    public boolean canApply(ItemStack stack) { return stack.getItem() instanceof ItemAxe; }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) { return false; }

    @Override
    public boolean canApplyTogether(Enchantment other) { return super.canApplyTogether(other); }

    @Override
    public float calcDamageByCreature(int level, EnumCreatureAttribute creatureType) {
        return creatureType == EnumCreatureAttribute.ILLAGER ? 2.5f * level : 0.0f;
    }
}