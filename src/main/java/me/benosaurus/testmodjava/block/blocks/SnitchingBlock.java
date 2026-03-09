package me.benosaurus.testmodjava.block.blocks;

import me.benosaurus.testmodjava.block.blockEntities.SnitchingBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.mojang.serialization.MapCodec;

public class SnitchingBlock extends BlockWithEntity {

    public static final String NAME = "snitching_block";

    public SnitchingBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(SnitchingBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SnitchingBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        if (!world.isClient() && placer instanceof PlayerEntity player) {

            BlockEntity blocketity = world.getBlockEntity(pos);

            if (blocketity instanceof SnitchingBlockEntity snitchingBlockEntity) {
                snitchingBlockEntity.setPlayerName(player.getName().getString());
            }
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (!world.isClient()) {
            BlockEntity be = world.getBlockEntity(pos);

            if (be instanceof SnitchingBlockEntity snitchingBlockEntity) {
                String playerName = snitchingBlockEntity.getPlayerName();
                player.sendMessage(Text.literal("This block was placed by: " + playerName), false);
            }

        }
        return ActionResult.SUCCESS;
    }
}