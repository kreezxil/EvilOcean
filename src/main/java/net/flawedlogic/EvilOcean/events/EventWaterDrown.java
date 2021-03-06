package net.flawedlogic.EvilOcean.events;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event.HasResult;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
@HasResult
public class EventWaterDrown extends PlayerEvent {
	public EventWaterDrown(EntityPlayer player) {
		super(player);
	}

	@SubscribeEvent
	public boolean onLivingAttackEvent(LivingAttackEvent event) {
		if ((event.entityLiving instanceof EntityPlayer) && (event.source == DamageSource.drown)) {
			event.entityLiving.setHealth(0.5F);
			return true;
		}
		return false;
	}
}
