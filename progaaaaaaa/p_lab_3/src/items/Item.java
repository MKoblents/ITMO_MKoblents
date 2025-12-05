package items;

import creature.Creature;
import enym.Action;
import interfaces.Nameable;

public abstract class Item implements Nameable {
    private String name;
    private boolean isUsable;
    private String description;
    private String damage;
    private Creature owner;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract Action use(Creature creature);

    public Creature getOwner() {
        return owner;
    }

    public void setOwner(Creature owner) {
        this.owner = owner;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getDamage() {
        return damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void changeDescription(String description){
        this.description = this.description + description;
    }
    public void changeDamage(String damage){
        this.damage = this.damage +damage;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }
}
