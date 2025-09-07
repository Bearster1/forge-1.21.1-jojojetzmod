package net.bearster.jojojetzmod.item.custom;

import net.bearster.jojojetzmod.entity.custom.LexiBulletEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LexiMagItem extends Item {

    private final int MAX_CAPACITY = 20;

    enum Capacity {
        FULL("Full Magazine"),
        PARTIAL("Partial Magazine"),
        EMPTY("Empty Magazine");

        private final String name;

        public Component getName() {
            // I don't understand this >,> ~Kenobi
            return Component.translatable("names.jojojetzmod.full_magazine", name);
        }

        Capacity(String str) {
            name = str;
        }
    }

    private int _currentCapacity;

    public int getMaxCapacity() {
        return _currentCapacity;
    }

    public int getCurrentCapacity() {
        return _currentCapacity;
    }

    public LexiMagItem(Properties pProperties) {
        super(pProperties);
    }

    public void Spend() {
        if(_currentCapacity == 0) {
            return;
        }
        _currentCapacity--;
    }

    public void Load(int bullets) {
        if(_currentCapacity > MAX_CAPACITY) {
            _currentCapacity = MAX_CAPACITY;
            return;
        }

        _currentCapacity = bullets;
    }

    @Override
    @NotNull
    public Component getName(@Nullable ItemStack pStack) {
        if(_currentCapacity == MAX_CAPACITY) {
            return Capacity.FULL.getName();
        } else if (_currentCapacity <  MAX_CAPACITY && _currentCapacity > 0) {
            return Capacity.PARTIAL.getName();
        } else {
            return Capacity.EMPTY.getName();
        }
    }
}
