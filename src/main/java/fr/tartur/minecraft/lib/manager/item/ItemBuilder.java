package fr.tartur.minecraft.lib.manager.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemBuilder {

    private int amount;
    private Material material;
    private MetaBuilder meta;

    public ItemBuilder() {
        this.amount = 1;
        this.material = Material.STONE;
    }

    public ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ItemBuilder setMeta(MetaBuilder meta) {
        this.meta = meta;
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(this.material, this.amount);
        if (itemStack.getItemMeta() != null && this.meta != null) this.meta.build(itemStack.getItemMeta());

        return itemStack;
    }
}
