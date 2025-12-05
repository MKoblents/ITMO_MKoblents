package items;

import java.util.ArrayList;

public class Container extends Item{
    private ArrayList<Item> content;

    public Boolean has(Item item){
        return content.contains(item);
    }
    public Boolean addContent(Item item){
        if (has(item)){//TODO добавить описание про то кому пренадлежит контенер, чтобы выводилось
            System.out.println(this.getName()+" already has "+ item.getName());
            return false;
        }else{
            return content.add(item);
        }
    }
    public Boolean removeContent(Item item){
        if (has(item)){
            return content.remove(item);
        }else{//TODO добавить описание про то кому пренадлежит контенер, чтобы выводилось
            System.out.println(this.getName()+" doesn't have "+ item.getName());
            return false;
        }
    }
}
