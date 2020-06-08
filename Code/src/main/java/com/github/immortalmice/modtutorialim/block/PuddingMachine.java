package com.github.immortalmice.modtutorialim.block;

import java.util.Arrays;
import java.util.List;

import com.github.immortalmice.modtutorialim.item.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraftforge.common.ToolType;

public class PuddingMachine extends Block{
	public PuddingMachine(){
		super(Block.Properties.create(Material.IRON)
			.hardnessAndResistance(5.0f, 6.0f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2) // Iron pickaxe and above
			.lightValue(15)
			.notSolid());
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
		return Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	}

	@Override
	@SuppressWarnings("deprecation")
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder){
		ResourceLocation resourcelocation = this.getLootTable();
		LootTableManager manager = builder.getWorld().getServer().getLootTableManager();
		if(manager.getLootTableFromLocation(resourcelocation) != LootTable.EMPTY_LOOT_TABLE){
			return super.getDrops(state, builder);
		}
		return Arrays.asList(new ItemStack(Items.PUDDING_MACHINE));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit){
		if(worldIn.isRemote) return ActionResultType.CONSUME;

		if(!player.isSneaking()){
			ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(Items.PUDDING));
			worldIn.addEntity(itemEntity);
			
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.PASS;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
		builder.add(BlockStateProperties.HORIZONTAL_FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context){
		return this.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
}