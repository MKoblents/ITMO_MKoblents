package items;

import creature.Creature;
import creature.HumanCharacter;
import enym.Action;

public class Cloth extends Item{
    private boolean isClean;

    @Override
    public Action use(HumanCharacter humanCharacter) {
        humanCharacter.addCloth(this);
        humanCharacter.addAction(Action.WEAR);
        return Action.WEAR;
    }
    public void setClean(boolean b){
        this.isClean = b;
    }
    public boolean isClean(){
        return isClean;
    }
}
