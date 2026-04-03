package me.benosaurus.testmodjava.entity.client.july;

import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.entity.custom.JulyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class JulyRenderer extends MobEntityRenderer<JulyEntity, JulyRenderState, BipedEntityModel<JulyRenderState>> {
    private static final Identifier TEXTURE = Identifier.of(TestModJava.MOD_ID, "textures/entity/july.png");

    public JulyRenderer(EntityRendererFactory.Context context) {
        super(context, new BipedEntityModel<>(context.getPart(EntityModelLayers.PLAYER)), 0.5f);
    }

    @Override
    public JulyRenderState createRenderState() {
        return new JulyRenderState();
    }

    @Override
    public void updateRenderState(JulyEntity entity, JulyRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.sneaking = entity.isSneaking();
    }

    @Override
    public Identifier getTexture(JulyRenderState state) {
        return TEXTURE;
    }
}