package com.github.immortalmice.modtutorialim.bus;

import com.github.immortalmice.modtutorialim.block.Blocks;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModEventHandlers{
	private static final IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();

	public static void registEvents(){
		ModEventHandlers.BUS.register(ModEventHandlers.class);
		ModEventHandlers.BUS.register(new ModEventHandlers());
	}

	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event){
	    ForgeEventHandlers.registEvents();
	}

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event){
		RenderTypeLookup.setRenderLayer(Blocks.PUDDING_MACHINE, RenderType.getCutoutMipped());
	}
}