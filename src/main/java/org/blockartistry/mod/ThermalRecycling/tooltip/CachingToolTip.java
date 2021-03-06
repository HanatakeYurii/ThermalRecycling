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

package org.blockartistry.mod.ThermalRecycling.tooltip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.blockartistry.mod.ThermalRecycling.util.function.MultiFunction;

public abstract class CachingToolTip implements MultiFunction<List<String>, ItemStack, Void> {

	private Item lastItem;
	private int lastMeta;
	private List<String> cachedLore = Collections.emptyList();

	public abstract void addToToolTip(final List<String> output, final ItemStack stack);
	
	@Override
	public Void apply(final List<String> output, final ItemStack stack) {
		
		final Item item = stack.getItem();
		final int meta = stack.getItemDamage();
		if(lastItem == item && lastMeta == meta) {
			output.addAll(cachedLore);
			return null;
		}
		
		lastItem = item;
		lastMeta = meta;
		cachedLore = new ArrayList<String>();
		
		addToToolTip(cachedLore, stack);
		output.addAll(cachedLore);
		
		return null;
	}

}
