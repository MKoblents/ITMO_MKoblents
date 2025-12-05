package creature;

import interfaces.Nameable;
import locations.*;
import enym.Action;

import java.util.ArrayList;

public abstract class Creature implements Nameable {
    private boolean isAlive;
    private String name;
    private ArrayList<Action> actions;
    private Location currentLocation;
    private ArrayList<Action> disableAction;

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public void die(){
        System.out.println(this.name + "died!!!");
        this.isAlive = false;
    }
    public ArrayList<Action> getActions() {
        return actions;
    }
    public boolean addAction(Action action){
        if (this.actions.contains(action)){
            System.out.println(this.name +" already does "+ action);
            return false;
        }
        return this.actions.add(action);
    }
    public boolean removeAction(Action action){
        return  this.actions.remove(action);
    }
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    public Location getCurrentLocation() {
        return currentLocation;
    }
    public boolean addDisableAction(Action action){
        if (this.disableAction.contains(action)){
            System.out.println(action + "already disable!!");
            return false;
        }
        return this.disableAction.add(action);
    }
    public boolean removeDisableAction(Action action){
        return this.disableAction.remove(action);
    }
    public boolean isAble(Action action){
        if (! this.disableAction.contains(action)){
            return true;
        }
        return false;
    }
    public ArrayList<Action> getDisableAction(){return disableAction;}
}

