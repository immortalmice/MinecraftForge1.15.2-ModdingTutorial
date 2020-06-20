package com.github.immortalmice.modtutorialim;

import net.minecraftforge.fml.common.Mod;
import com.github.immortalmice.modtutorialim.bus.ModEventHandlers;
import com.github.immortalmice.modtutorialim.handlers.RegistryHandler;

@Mod(ModTutorialIM.MODID)
public class ModTutorialIM{
	public static final String MODID = "modtutorialim";
    public static final String NAME = "Immortalmice's Mod Tutorial";

    public ModTutorialIM(){
    	RegistryHandler.registAll();
    	ModEventHandlers.registEvents();
    }
}