package me.benosaurus.testmodjava.block.blockEntities;

import me.benosaurus.testmodjava.block.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;

public class XPBankBlockEntity extends BlockEntity {

    private int xpCount = 0;

    public XPBankBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.XP_BANK_BLOCK_ENTITY, pos, state);
    }

    public int getXPCount() {
        return this.xpCount;
    }

    public void incrementXPCount() {
        this.xpCount++;
        markDirty();
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        this.xpCount = view.getInt("xp_count", 0);
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        view.putInt("xp_count", this.xpCount);
    }
}