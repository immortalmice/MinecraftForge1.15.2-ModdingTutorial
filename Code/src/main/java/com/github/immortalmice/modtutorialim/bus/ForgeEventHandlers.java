package com.github.immortalmice.modtutorialim.bus;

import com.github.immortalmice.modtutorialim.item.Items;
import com.github.immortalmice.modtutorialim.potion.Effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
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

	@SubscribeEvent
	public static void onLivingAttacked(LivingAttackEvent event){
		if(event.getEntityLiving().world.isRemote()) return;

		LivingEntity target = event.getEntityLiving();

		/* If target is monster && damage is caused by arrow && attaker is entity */
		if(target instanceof MonsterEntity 
			&& event.getSource().getImmediateSource() instanceof ArrowEntity 
			&& event.getSource() instanceof EntityDamageSource){

			Entity shooter = ((EntityDamageSource) event.getSource()).getTrueSource();
			/* If attacker is player && player has PUDDING_EFFECT active */
			if(shooter instanceof PlayerEntity 
				&& ((PlayerEntity) shooter).getActivePotionEffect(Effects.PUDDING_EFFECT) != null){

				BlockPos pos = target.getPosition();
				World world = target.world;

				ItemEntity pudding = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.PUDDING));
				target.remove(false);
				world.addEntity(pudding);
			}
		}
	}
}