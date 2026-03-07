package me.benosaurus.testmodjava.mixin;

import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Block.class)
public class SlipperinessMixin {

	@Inject(method = "getSlipperiness", at = @At("RETURN"), cancellable = true)


	private void blockSlipperiness(CallbackInfoReturnable<Float> info) {
		info.setReturnValue(0.98f);
	}
}