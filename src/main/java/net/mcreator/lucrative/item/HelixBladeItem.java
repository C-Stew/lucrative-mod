
package net.mcreator.lucrative.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.lucrative.procedures.HelixBladeProjectileProcedure;
import net.mcreator.lucrative.procedures.HelixBladeMakeItemGlowProcedure;
import net.mcreator.lucrative.init.LucrativeModTabs;

import java.util.List;

public class HelixBladeItem extends SwordItem {
	public HelixBladeItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 9f;
			}

			public float getAttackDamageBonus() {
				return 12f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.65f, new Item.Properties().tab(LucrativeModTabs.TAB_LUCRATIVE_TAB).fireResistant());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		HelixBladeProjectileProcedure.execute(world, entity, ar.getObject());
		return ar;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		Entity entity = Minecraft.getInstance().player;
		return HelixBladeMakeItemGlowProcedure.execute(entity);
	}
}
