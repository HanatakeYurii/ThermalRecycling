/*
 * This file is part of ThermalRecycling, licensed under the MIT License (MIT).
 *
 * Copyright (c) OreCruncher
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.blockartistry.mod.ThermalRecycling;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.blockartistry.mod.ThermalRecycling.util.ItemBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class Material extends ItemBase {
	
	public static final int PAPER_LOG = 0;

	public Material() {
		super("paperlog");

		setUnlocalizedName("Material");
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	@Override
	public void register() {
		super.register();

		ShapedOreRecipe recipe = new ShapedOreRecipe(new ItemStack(
			ItemManager.material, 1, PAPER_LOG), "ppp", "plp", "ppp", 'p',
			new ItemStack(Items.paper), 'l', new ItemStack(
					ItemManager.paperLogMaker, 1,
					OreDictionary.WILDCARD_VALUE));

		GameRegistry.addRecipe(recipe);
	}
}
