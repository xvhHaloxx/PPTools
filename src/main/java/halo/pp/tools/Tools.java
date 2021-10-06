package halo.pp.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Tools implements ToolMaterial{

    @Override
    public float getAttackDamage() {
        return 0f;
    }

    @Override
    public int getDurability() {
        return 5223;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public int getMiningLevel() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 500f;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(PPTools.PP);
    }
    
}
