package me.benosaurus.testmodjava.entity.client.july;

import net.minecraft.client.render.entity.state.BipedEntityRenderState;

public class JulyRenderState extends BipedEntityRenderState {
    // For player-like model, we need these flags
    public boolean sneaking;
    public boolean swimming;
    public float leaningPitch;
}