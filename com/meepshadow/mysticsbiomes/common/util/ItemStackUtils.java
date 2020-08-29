package com.meepshadow.mysticsbiomes.common.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStackUtils {

    public static int findIndexOfItem(Item item, NonNullList<ItemStack> items) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getItem() == item) {
                return i;
            }
        }
        return -1;
    }

    public static String intToRomanNumerals(int number) {
        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String thousands = m[number / 1000];
        String hundereds = c[(number % 1000) / 100];
        String tens = x[(number % 100) / 10];
        String ones = i[number % 10];

        return thousands + hundereds + tens + ones;
    }

    public static boolean isInGroup(Item item, ItemGroup group) {
        if (item.getCreativeTabs().stream().anyMatch(tab -> tab == group)) return true;
        ItemGroup itemgroup = item.getGroup();
        return itemgroup != null && (group == ItemGroup.SEARCH || group == itemgroup);
    }
}
