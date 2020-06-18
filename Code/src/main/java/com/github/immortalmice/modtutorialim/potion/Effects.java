package com.github.immortalmice.modtutorialim.potion;

import com.github.immortalmice.modtutorialim.ModTutorialIM;

import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ModTutorialIM.MODID)
public class Effects{
	public static final PuddingEffect PUDDING_EFFECT = null;

	public static DeferredRegister<Effect> getRegister(){
		return Effects.EffectRegistry.REGISTER;
	}

	public static class EffectRegistry{
		public static final DeferredRegister<Effect> REGISTER = new DeferredRegister<Effect>(ForgeRegistries.POTIONS, ModTutorialIM.MODID);

		public static final RegistryObject<Effect> OBJ_PUDDING_EFFECT = EffectRegistry.REGISTER.register("pudding_effect", () -> new PuddingEffect());
	}
}