package com.github.immortalmice.modtutorialim.block;

import com.github.immortalmice.modtutorialim.ModTutorialIM;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ModTutorialIM.MODID)
public class Blocks{
	public static final PuddingMachine PUDDING_MACHINE = null;

	public static DeferredRegister<Block> getRegister(){
		return Blocks.BlockRegistry.REGISTER;
	}
	
	public static class BlockRegistry{
		public static final DeferredRegister<Block> REGISTER = new DeferredRegister<Block>(ForgeRegistries.BLOCKS, ModTutorialIM.MODID);

		public static final RegistryObject<Block> OBJ_PUDDING_MACHINE = BlockRegistry.REGISTER.register("pudding_machine", () -> new PuddingMachine());
	}
}