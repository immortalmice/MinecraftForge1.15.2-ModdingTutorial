package com.github.immortalmice.modtutorialim.potion;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class PuddingEffect extends Effect{
	public PuddingEffect(){
		super(EffectType.BENEFICIAL, 0xFFBB00);
		this.addAttributesModifier(
			SharedMonsterAttributes.MAX_HEALTH
			, "bfee1736-7fa7-4438-9ba2-4de281f85014"
			, 4.0D
			, AttributeModifier.Operation.ADDITION);
	}
}