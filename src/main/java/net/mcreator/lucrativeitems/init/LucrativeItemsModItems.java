
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lucrativeitems.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.lucrativeitems.item.HelixBladeItem;
import net.mcreator.lucrativeitems.item.HelixBeamItem;
import net.mcreator.lucrativeitems.LucrativeItemsMod;

public class LucrativeItemsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LucrativeItemsMod.MODID);
	public static final RegistryObject<Item> HELIX_BLADE = REGISTRY.register("helix_blade", () -> new HelixBladeItem());
	public static final RegistryObject<Item> HELIX_BEAM = REGISTRY.register("helix_beam", () -> new HelixBeamItem());
}
