package com.github.immortalmice.modtutorialim.potion;

import com.github.immortalmice.modtutorialim.ModTutorialIM;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ModTutorialIM.MODID)
public class Potions{
	public static final PuddingPotion PUDDING_POTION = null;
	public static final PuddingPotion LONG_PUDDING_POTION = null;

	public static DeferredRegister<Potion> getRegister(){
		return Potions.PotionRegistry.REGISTER;
	}

	public static class PotionRegistry{
		public static final DeferredRegister<Potion> REGISTER = new DeferredRegister<Potion>(ForgeRegistries.POTION_TYPES, ModTutorialIM.MODID);

		public static final RegistryObject<Potion> OBJ_PUDDING_POTION = PotionRegistry.REGISTER.register("pudding_potion", () -> new PuddingPotion(1200, 0));
		public static final RegistryObject<Potion> OBJ_LONG_PUDDING_POTION = PotionRegistry.REGISTER.register("long_pudding_potion", () -> new PuddingPotion(6000, 0));
	}
}