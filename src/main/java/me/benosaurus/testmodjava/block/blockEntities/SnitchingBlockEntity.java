package me.benosaurus.testmodjava.block.blockEntities;

import me.benosaurus.testmodjava.block.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;

public class SnitchingBlockEntity extends BlockEntity {

    private String playerName = "";

    public SnitchingBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SNITCHING_BLOCK_ENTITY, pos, state);
    }

    public void setPlayerName(String name) {
        this.playerName = name;
        markDirty();
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    protected void readData(ReadView view) {
        this.playerName = view.getString("player_name", "");
    }

    @Override
    protected void writeData(WriteView view) {
        view.putString("player_name", this.playerName);
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
}