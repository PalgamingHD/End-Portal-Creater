package net.portalcrafter.mixins;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class BlockMaterialMixin {
    @Inject(at = @At("HEAD"), method = "getHardness", cancellable = true)
    private void changeMaterial(BlockView world, BlockPos pos, CallbackInfoReturnable<Material> info) {
        if (world.getBlockState(pos).getBlock() == Blocks.END_PORTAL_FRAME) {
            info.setReturnValue(Material.GLASS);
        }
    }
}

