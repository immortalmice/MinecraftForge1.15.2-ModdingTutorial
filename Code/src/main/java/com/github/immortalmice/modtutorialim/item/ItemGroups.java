package com.github.immortalmice.modtutorialim.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroups{
	public static final ItemGroup ITEM_TAB = (new ItemGroup("modtutorialim.items"){
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon(){
			return new ItemStack(Items.PUDDING);
		}
	});
}