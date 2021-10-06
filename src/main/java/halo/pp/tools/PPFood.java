package halo.pp.tools;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class PPFood {

    public static final FoodComponent PP = (new FoodComponent.Builder()).hunger(20).saturationModifier(2.5F).statusEffect(new StatusEffectInstance
    (StatusEffects.HASTE, 160, 2), 1F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 3), 1).snack().alwaysEdible().build();

}
