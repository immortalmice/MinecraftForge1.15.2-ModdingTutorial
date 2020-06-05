package com.github.immortalmice.modtutorialim.handlers;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.github.immortalmice.modtutorialim.block.Blocks;
import com.github.immortalmice.modtutorialim.item.Items;

public class RegistryHandler{
	private static IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();

	public static void registAll(){
		Items.getRegister().register(RegistryHandler.BUS);
		Blocks.getRegister().register(RegistryHandler.BUS);
	}
}