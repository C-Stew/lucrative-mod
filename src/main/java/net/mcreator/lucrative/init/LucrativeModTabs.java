
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lucrative.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class LucrativeModTabs {
	public static CreativeModeTab TAB_LUCRATIVE_TAB;

	public static void load() {
		TAB_LUCRATIVE_TAB = new CreativeModeTab("tablucrative_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.DIAMOND_SWORD);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
