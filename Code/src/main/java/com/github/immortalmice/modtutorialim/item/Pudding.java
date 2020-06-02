package com.github.immortalmice.modtutorialim.item;

import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Pudding extends Item{
	public Pudding(){
		super((new Item.Properties())
			.maxStackSize(1)
			.rarity(Rarity.EPIC)
			.group(ItemGroups.ITEM_TAB)
			.food((new Food.Builder())
				.hunger(4)
				.saturation(2.0f)
				.setAlwaysEdible()
				.build())
			);
	}

	@Override
	public int getUseDuration(ItemStack stack){
		return 2;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
		boolean isShiftDown = Screen.hasShiftDown();

		if(!isShiftDown){
			tooltip.add(new TranslationTextComponent("tooltip.modtutorialim.hold_shift_descript"));
		}else{
			tooltip.add(new TranslationTextComponent("tooltip.modtutorialim.pudding.descript_1"));
			tooltip.add(new StringTextComponent(""));
			tooltip.add(new TranslationTextComponent("tooltip.modtutorialim.pudding.descript_2"));
			tooltip.add(new TranslationTextComponent("tooltip.modtutorialim.pudding.descript_3"));
			tooltip.add(new TranslationTextComponent("tooltip.modtutorialim.pudding.descript_4"));
			tooltip.add(new TranslationTextComponent("tooltip.modtutorialim.pudding.descript_5"));
			tooltip.add(new StringTextComponent(""));
			tooltip.add(new TranslationTextComponent("tooltip.modtutorialim.pudding.descript_6"));
			tooltip.add(new StringTextComponent(""));
			tooltip.add((new TranslationTextComponent("tooltip.modtutorialim.pudding.descript_7"))
				.setStyle((new Style())
					.setBold(true)
					.setItalic(true)
					.setColor(TextFormatting.GOLD)
				)
			);
		}
	}
}