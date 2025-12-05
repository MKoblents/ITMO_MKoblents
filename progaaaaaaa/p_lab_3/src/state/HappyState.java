package state;

import creature.Creature;
import enym.Action;
import interfaces.BehaviorState;

public class HappyState implements BehaviorState {
    private Creature owner;
    public HappyState(Creature owner){
        this.owner = owner;
    }

    @Override
    public Action speak(Creature creature, String string) {

    }

    @Override
    public Action cry(String string) {

        return null;
    }
}
