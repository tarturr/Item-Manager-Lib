package fr.tartur.minecraft.lib.manager.item;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class MetaBuilder {

    private String name;
    private List<String> lore;
    private final List<ItemFlag> itemFlags;
    private final Map<Enchantment, Integer> enchantments;
    private boolean isUnbreakable;

    public MetaBuilder() {
        this.name = " ";
        this.lore = new ArrayList<>();
        this.itemFlags = new ArrayList<>();
        this.enchantments = new HashMap<>();
        this.isUnbreakable = false;
    }

    public MetaBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MetaBuilder setLore(String... lines) {
        this.lore = new ArrayList<>(Arrays.asList(lines));
        return this;
    }

    public MetaBuilder setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public MetaBuilder addItemFlags(ItemFlag... itemFlags) {
        this.itemFlags.addAll(Arrays.asList(itemFlags));
        return this;
    }

    public MetaBuilder addEnchant(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);
        return this;
    }

    public MetaBuilder addEnchants(int defaultLevel, Enchantment... enchantments) {
        for (Enchantment enchantment : enchantments)
            this.enchantments.put(enchantment, defaultLevel);

        return this;
    }

    public MetaBuilder setUnbreakable(boolean unbreakable) {
        this.isUnbreakable = unbreakable;
        return this;
    }

    public ItemMeta build(ItemMeta meta) {
        meta.setDisplayName(this.name);

        if (this.lore.size() != 0) meta.setLore(this.lore);

        if (this.itemFlags.size() != 0)
            for (ItemFlag itemFlag : this.itemFlags)
                meta.addItemFlags(itemFlag);

        if (this.enchantments.size() != 0)
            for (Enchantment enchantment : this.enchantments.keySet())
                meta.addEnchant(enchantment, this.enchantments.get(enchantment), true);

        meta.setUnbreakable(isUnbreakable);

        return meta;
    }

}
