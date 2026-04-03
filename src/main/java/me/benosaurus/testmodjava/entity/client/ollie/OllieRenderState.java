package me.benosaurus.testmodjava.entity.client.ollie;

import net.minecraft.client.render.entity.state.BipedEntityRenderState;

public class OllieRenderState extends BipedEntityRenderState {
    // For player-like model, we need these flags
    public boolean sneaking;
    public boolean swimming;
    public float leaningPitch;
}