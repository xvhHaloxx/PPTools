package halo.pp.tools;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class Armor implements ArmorMaterial {

    public static final int[] BASE_DURABILITY = new int[] {125, 350, 225, 125};
    public static final int[] PROTECTION_AMOUNTS = new int[] {8, 11, 13, 8};

    @Override
    public int getDurability(EquipmentSlot arg0) {
        return BASE_DURABILITY[arg0.getEntitySlotId()]*10;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot arg0) {
        return PROTECTION_AMOUNTS[arg0.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(PPTools.PP);
    }

    @Override
    public String getName() {
        return "dick";
    }

    @Override
    public float getToughness() {
        return 8;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.2f;
    }

}
