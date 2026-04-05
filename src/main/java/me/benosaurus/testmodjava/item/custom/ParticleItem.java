package me.benosaurus.testmodjava.item.custom;

import me.benosaurus.testmodjava.block.ModBlocks;
import me.benosaurus.testmodjava.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class ParticleItem extends Item {

    public ParticleItem(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        if (world.isClient()) {

            BlockPos pos = context.getBlockPos();
            BlockState state = world.getBlockState(pos);

            if (state.isOf(Blocks.DIAMOND_BLOCK)) {
                for (int i = 0; i < 20; i++) {

                    double dX = (world.random.nextDouble() - 0.5) * 0.2;
                    double dZ = (world.random.nextDouble() - 0.5) * 0.2;

                    world.addParticleClient(ModParticles.TEST_PARTICLE,
                            pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5,
                            dX, 0.1, dZ);
                }
            }

        }
        return ActionResult.SUCCESS;
    }

}