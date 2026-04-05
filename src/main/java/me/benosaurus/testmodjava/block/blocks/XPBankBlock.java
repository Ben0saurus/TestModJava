package me.benosaurus.testmodjava.block.blocks;

import com.mojang.serialization.MapCodec;
import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.block.ModBlocks;
import me.benosaurus.testmodjava.block.blockEntities.CounterBlockEntity;
import me.benosaurus.testmodjava.block.blockEntities.XPBankBlockEntity;
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

public class XPBankBlock extends BlockWithEntity {

    public static final String NAME = "xp_bank_block";

    public static final MapCodec<XPBankBlock> CODEC = createCodec(XPBankBlock::new);


    public XPBankBlock(AbstractBlock.Settings settings) {
        super(settings);
    }


    public XPBankBlock() {
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
        return new XPBankBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (!world.isClient()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof XPBankBlockEntity xpBankBlockEntity) {

                int count = xpBankBlockEntity.getXPCount();

                if (player.experienceLevel != 0) {
                    player.addExperienceLevels(-1);
                    xpBankBlockEntity.incrementXPCount();
                    player.sendMessage(Text.literal("Levels saved: " + count), true);
                    xpBankBlockEntity.incrementXPCount();
                } else {
                    player.sendMessage(Text.literal("Not enough levels. Current saved levels:" + count), true);
                }

            }
        }

        return ActionResult.SUCCESS;
    }


    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        if (!world.isClient()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof XPBankBlockEntity xpBankBlockEntity) {
                int storedLevels = xpBankBlockEntity.getXPCount();
                if (storedLevels > 0) {
                    player.addExperienceLevels(storedLevels);
                    player.sendMessage(Text.literal("Bank broken! Recovered " + storedLevels + " levels."), false);
                }
            }
        }

        return super.onBreak(world, pos, state, player);
    }

}