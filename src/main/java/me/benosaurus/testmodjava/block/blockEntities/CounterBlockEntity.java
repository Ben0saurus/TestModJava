package me.benosaurus.testmodjava.block.blockEntities;

import me.benosaurus.testmodjava.block.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;

public class CounterBlockEntity extends BlockEntity {

    private int clickCount = 0;

    public CounterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COUNTER_BLOCK_ENTITY, pos, state);
    }

    public int getClickCount() {
        return this.clickCount;
    }

    public void incrementCount() {
        this.clickCount++;
        markDirty();
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        this.clickCount = view.getInt("click_count", 0);
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        view.putInt("click_count", this.clickCount);
    }
}