package com.github.immortalmice.modtutorialim.item;

import com.github.immortalmice.modtutorialim.block.Blocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroups{
	public static final ItemGroup ITEM_TAB = (new ItemGroup("modtutorialim.items"){
		@Override
		public ItemStack createIcon(){
			return new ItemStack(Items.PUDDING);
		}
	});

	public static final ItemGroup BLOCK_TAB = (new ItemGroup("modtutorialim.blocks"){
		@Override
		public ItemStack createIcon(){
			return new ItemStack(Blocks.PUDDING_MACHINE.asItem());
		}
	});
}