package com.github.immortalmice.modtutorialim.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import com.github.immortalmice.modtutorialim.block.Blocks.BlockRegistry;
import com.github.immortalmice.modtutorialim.ModTutorialIM;

@ObjectHolder(ModTutorialIM.MODID)
public class Items{
	public static final Pudding PUDDING = null;
	public static final Item PUDDING_MACHINE = null;

	public static DeferredRegister<Item> getRegister(){
		return Items.ItemRegistry.REGISTER;
	}
	
	public static class ItemRegistry{
		public static final DeferredRegister<Item> REGISTER = new DeferredRegister<Item>(ForgeRegistries.ITEMS, ModTutorialIM.MODID);

		public static final RegistryObject<Item> OBJ_PUDDING = ItemRegistry.REGISTER.register("pudding", () -> new Pudding());
		public static final RegistryObject<Item> OBJ_PUDDING_MACHINE = ItemRegistry.REGISTER.register("pudding_machine", () -> new BlockItem(BlockRegistry.OBJ_PUDDING_MACHINE.get(), new Item.Properties().group(ItemGroups.BLOCK_TAB)));
	}
}

