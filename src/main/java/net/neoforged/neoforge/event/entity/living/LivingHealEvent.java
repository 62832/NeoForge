/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.neoforged.neoforge.event.entity.living;

import net.neoforged.neoforge.common.MinecraftForge;
import net.neoforged.neoforge.event.ForgeEventFactory;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * LivingHealEvent is fired when an Entity is set to be healed. <br>
 * This event is fired whenever an Entity is healed in {@link LivingEntity#heal(float)}<br>
 * <br>
 * This event is fired via the {@link ForgeEventFactory#onLivingHeal(LivingEntity, float)}.<br>
 * <br>
 * {@link #amount} contains the amount of healing done to the Entity that was healed. <br>
 * <br>
 * This event is {@link net.neoforged.bus.api.ICancellableEvent}.<br>
 * If this event is canceled, the Entity is not healed.<br>
 * <br>
 * This event does not have a result. {@link HasResult}<br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
 **/
public class LivingHealEvent extends LivingEvent implements ICancellableEvent
{
    private float amount;
    public LivingHealEvent(LivingEntity entity, float amount)
    {
        super(entity);
        this.setAmount(amount);
    }

    public float getAmount()
    {
        return amount;
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }
}
