package com.github.immortalmice.modtutorialim.bus;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEventHandlers{
	private static final IEventBus BUS = MinecraftForge.EVENT_BUS;
	
	public static void registEvents(){
		ForgeEventHandlers.BUS.register(ForgeEventHandlers.class);
		ForgeEventHandlers.BUS.register(new ForgeEventHandlers());
	}

	@SubscribeEvent
	public static void onThrowableImpact(ProjectileImpactEvent.Throwable event){
		ThrowableEntity throwable = event.getThrowable();
		if(!throwable.world.isRemote() && throwable instanceof EggEntity){
			BlockPos impactPos = throwable.getPosition();
			World world = throwable.world;
			
			/* Create a creeper instance */
			CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, world);
			creeper.setPosition(impactPos.getX(), impactPos.getY(), impactPos.getZ());
			
			/* Set creeper to charged */
			CompoundNBT nbt = new CompoundNBT();
			nbt.putBoolean("powered", true);
			creeper.readAdditional(nbt);
			
			/* Add creeper to world */
			world.addEntity(creeper);
		}
	}
}