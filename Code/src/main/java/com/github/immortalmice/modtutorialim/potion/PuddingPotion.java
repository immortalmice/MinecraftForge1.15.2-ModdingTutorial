package com.github.immortalmice.modtutorialim.potion;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;

public class PuddingPotion extends Potion{
	public PuddingPotion(int durationIn, int amplifierIn){
		super("pudding_effect", new EffectInstance(Effects.PUDDING_EFFECT, durationIn, amplifierIn));
	}
}