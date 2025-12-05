package locations;

import creature.Creature;
import enym.Smell;
import interfaces.Nameable;
import items.*;

import java.util.ArrayList;

public class Location implements Nameable {
    private String name;
    private ArrayList<Creature> creaturesHere;
    private ArrayList<Item> itemsHere;
    private Smell smell;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setSmell(Smell smell) {
        this.smell = smell;
    }

    public Smell getSmell() {
        return smell;
    }

    public ArrayList<Creature> getCreaturesHere() {
        return creaturesHere;
    }

    public void setCreaturesHere(ArrayList<Creature> creaturesHere) {
        this.creaturesHere = creaturesHere;
    }

    public ArrayList<Item> getItemsHere() {
        return itemsHere;
    }

    public void setItemsHere(ArrayList<Item> itemsHere) {
        this.itemsHere = itemsHere;
    }

    public boolean addItem(Item item) {
        if (this.itemsHere.contains(item)){
            System.out.println("This item already here.");
            return false;
        }
        return this.itemsHere.add(item);
    }
    public  boolean removeItem(Item item){
        return this.itemsHere.remove(item);
    }
    public boolean addCreature(Creature creature) {
        if (this.creaturesHere.contains(creature)){
            System.out.println("This creature already here.");
            return false;
        }
        return this.creaturesHere.add(creature);
    }
    public  boolean removeCreature(Creature creature){
        return this.creaturesHere.remove(creature);
    }
}
