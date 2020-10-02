package net.portalcrafter.mixins;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContext;
import net.portalcrafter.PortalCrafter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(AbstractBlock.class)
public class DropPlease
{
    @Inject(at = @At("HEAD"), method = "getDroppedStacks", cancellable = true)
    public void dropSmtn(BlockState state, LootContext.Builder builder, CallbackInfoReturnable<List<ItemStack>> ci)
    {
        if(state.getBlock() == Blocks.END_PORTAL_FRAME)
        {
                List<ItemStack> drops = new ArrayList<>();
                drops.add(new ItemStack(Items.END_PORTAL_FRAME, 1));
                ci.setReturnValue(drops);

        }
    }
}
