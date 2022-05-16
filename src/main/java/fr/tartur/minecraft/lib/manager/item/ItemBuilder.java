package fr.tartur.minecraft.lib.manager.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ItemBuilder {

    private String name;
    private List<String> lore;
    private List<ItemFlag> itemFlags;
    private int amount;

    private Material material;
    private ItemMeta meta;

    public ItemBuilder() {
        this.name = " ";
        this.amount = 1;

        this.material = Material.STONE;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setLore(String... lines) {
        this.lore = new ArrayList<>(Arrays.asList(lines));
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setMeta(ItemMeta meta) {
        this.meta = meta;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(this.material, this.amount);

        if (this.meta != null) {
            itemStack.setItemMeta(this.meta);
            return itemStack;
        }

        ItemMeta itemMeta = Objects.requireNonNull(itemStack.getItemMeta());
        itemMeta.setDisplayName(this.name);
        if (this.lore != null) itemMeta.setLore(this.lore);

        // TODO : s'occuper des ItemFlags, des Enchants, fonction pour unbreakable.

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
