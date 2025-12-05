package interfaces;

import creature.Creature;
import enym.Action;

public interface BehaviorState {
    Action speak(Creature creature, String string);
    Action ask(Creature creature, String string);
    Action cry(String string);
    Action whisper(Creature creature, String string);
    Action shout(Creature creature, String string);
    Action go(String string);
    Action shift();
}
