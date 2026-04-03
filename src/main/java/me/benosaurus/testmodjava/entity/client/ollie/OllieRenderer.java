package me.benosaurus.testmodjava.entity.client.ollie;

import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.entity.custom.OllieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class OllieRenderer extends MobEntityRenderer<OllieEntity, OllieRenderState, BipedEntityModel<OllieRenderState>> {
    private static final Identifier TEXTURE = Identifier.of(TestModJava.MOD_ID, "textures/entity/ollie.png");

    public OllieRenderer(EntityRendererFactory.Context context) {
        super(context, new BipedEntityModel<>(context.getPart(EntityModelLayers.PLAYER)), 0.5f);
    }

    @Override
    public OllieRenderState createRenderState() {
        return new OllieRenderState();
    }

    @Override
    public void updateRenderState(OllieEntity entity, OllieRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.sneaking = entity.isSneaking();
    }

    @Override
    public Identifier getTexture(OllieRenderState state) {
        return TEXTURE;
    }
}