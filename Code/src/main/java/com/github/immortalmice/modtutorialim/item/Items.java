package com.github.immortalmice.modtutorialim.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import com.github.immortalmice.modtutorialim.ModTutorialIM;

@ObjectHolder("modtutorialim")
public class Items{
	public static final Pudding PUDDING = null;

	public static DeferredRegister<Item> getRegister(){
		return ItemRegistry.REGISTER;
	}
}

class ItemRegistry{
	public static final DeferredRegister<Item> REGISTER = new DeferredRegister<Item>(ForgeRegistries.ITEMS, ModTutorialIM.MODID);

	public static final RegistryObject<Item> OBJ_PUDDING = ItemRegistry.REGISTER.register("pudding", () -> new Pudding());
}