package me.benosaurus.testmodjava.block.blocks;

import com.mojang.serialization.MapCodec;
import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.block.ModBlocks;
import me.benosaurus.testmodjava.block.blockEntities.CounterBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CounterBlock extends BlockWithEntity {

    public static final String NAME = "counter_block";

    public static final MapCodec<CounterBlock> CODEC = createCodec(CounterBlock::new);


    public CounterBlock(AbstractBlock.Settings settings) {
        super(settings);
    }


    public CounterBlock() {
        this(AbstractBlock.Settings.create()
                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TestModJava.MOD_ID, NAME)))
                .strength(2f)
                .sounds(BlockSoundGroup.STONE));
    }


    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CounterBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        y++;

        while (y < world.getHeight() && world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof CounterBlock) {
            y++;
        }

        if (y < world.getHeight()) {
            world.setBlockState(new BlockPos(x, y, z), ModBlocks.COUNTER_BLOCK.getDefaultState());
        }


        if (!world.isClient()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof CounterBlockEntity counterEntity) {
                counterEntity.incrementCount();
                int count = counterEntity.getClickCount();
                player.sendMessage(Text.literal("Click count: " + count), true);
            }
        }

        return ActionResult.SUCCESS;
    }
}