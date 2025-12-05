package creature;

import enym.Hairstyle;
import enym.Role;
import items.Cloth;
import locations.House;

import java.util.ArrayList;

public class HumanCharacter extends Mammal{
    private ArrayList<Cloth> clothes;
    private int age;
    private House house;
    private Hairstyle hairstyle;
    private Role role;

    public HumanCharacter(String name, int age){
        this.age = age;
        setName(name);
    }

    public Hairstyle getHairstyle() {
        return hairstyle;
    }
    public void setHairstyle(Hairstyle hairstyle){
        this.hairstyle = hairstyle;
    }
    public void setRole(Role role){
        this.role = role;
    }
    public Role getRole(){
        return role;
    }
    public void live(House house){
        this.house = house;
    }
    public boolean addCloth(Cloth cloth){
        if (clothes.contains(cloth)){
            System.out.println(getName()+" already wears "+cloth);
            return false;
        }else{
            return clothes.add(cloth);
        }
    }
    public boolean removeCloth(Cloth cloth){
        if (clothes.contains(cloth)){
            System.out.println(getName()+" took off "+ cloth);
            return clothes.remove(cloth);
        }else {
            System.out.println(getName()+" doesn't wear "+cloth);
            return  false;
        }
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){return age;}
}
