package com.moos2333.lostenchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnchantmentFreeze extends Enchantment {
    public EnchantmentFreeze() {
        super(Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND });
        this.setName("lostenchants.freeze");
    }

    @Override
    public int getMinLevel() { return 1; }

    @Override
    public int getMaxLevel() { return 2; }

    @Override
    public int getMinEnchantability(int level) { return 10 + (level - 1) * 15; }

    @Override
    public int getMaxEnchantability(int level) { return getMinEnchantability(level) + 30; }

    @Override
    public boolean isTreasureEnchantment() { return true; }

    @Override
    public boolean canApply(ItemStack stack) { return stack.getItem() instanceof ItemSword; }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) { return false; }

    @Override
    public boolean canApplyTogether(Enchantment other) { return super.canApplyTogether(other); }

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        if (!user.world.isRemote && target instanceof EntityLivingBase) {
            EntityLivingBase livingTarget = (EntityLivingBase) target;
            livingTarget.addPotionEffect(new PotionEffect(
                    Potion.getPotionFromResourceLocation("slowness"),
                    (4 + level) * 20,
                    level - 1
            ));
        }
    }
}