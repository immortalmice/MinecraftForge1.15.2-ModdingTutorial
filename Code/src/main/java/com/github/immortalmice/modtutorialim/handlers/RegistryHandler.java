package com.github.immortalmice.modtutorialim.handlers;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.github.immortalmice.modtutorialim.block.Blocks;
import com.github.immortalmice.modtutorialim.item.Items;
import com.github.immortalmice.modtutorialim.potion.Effects;
import com.github.immortalmice.modtutorialim.potion.Potions;

public class RegistryHandler{
	private static IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();

	public static void registAll(){
		Items.getRegister().register(RegistryHandler.BUS);
		Blocks.getRegister().register(RegistryHandler.BUS);
		Effects.getRegister().register(RegistryHandler.BUS);
		Potions.getRegister().register(RegistryHandler.BUS);
	}
}