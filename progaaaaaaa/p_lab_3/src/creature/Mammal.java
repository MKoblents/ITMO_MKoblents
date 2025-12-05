package creature;

import enym.Emotions.HappyEmotions;
import enym.Emotions.NervousEmotions;
import enym.Emotions.SadEmotions;
import enym.Emotions.StoicEmotions;
import enym.Emotions.NormalEmotions;
import interfaces.Emotion;
import enym.Pose;
import interfaces.BehaviorState;
import interfaces.Nameable;
import items.Container;
import items.*;

import java.util.*;

import state.*;

public class Mammal extends Creature{
    private ArrayList<String> memory;
    private final ArrayList<BehaviorState> behaviorStates = new ArrayList<>(Arrays.asList(
            new SadState(),
            new HappyState(),
            new StoicState(),
            new NervousState(),
            new NormalState()));
    private Container container;
    private ArrayList<Emotion> emotions;
    private ArrayList<Creature> conflictWith;
    private ArrayList<Emotion> disableEmotion;
    private int voiceVolume;
    private Pose pose;
    private boolean isEyesOpen;
    private boolean isEyesWet;
    private ArrayList<Nameable> view;

    public ArrayList<String> getMemory() {
        return memory;
    }

    private Emotion getPriorityEmotion(){
        Map<Emotion,Integer> map = new HashMap<>();
        Emotion e1 = SadEmotions.SAD;
        Emotion e2 = HappyEmotions.HAPPY;
        Emotion e3 = StoicEmotions.STOIC;
        Emotion e4 = NervousEmotions.NERVOUS;
        map.put(e1, 0);
        map.put(e2,0);
        map.put(e3,0);
        map.put(e4, 0);
        for (Emotion e: emotions) {
            if (e instanceof HappyEmotions) {
                map.merge(e2, 0, Integer::sum);
            }
            if (e instanceof SadEmotions) {
                map.merge(e1, 0, Integer::sum);
            }
            if (e instanceof StoicEmotions) {
                map.merge(e3, 0, Integer::sum);
            }
            if (e instanceof NervousEmotions) {
                map.merge(e4, 0, Integer::sum);
                ;
            }
        }
        Emotion priorityEmotion = map.entrySet()//TODO разобраться
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(NormalEmotions.NORMAL);
        return priorityEmotion;
    }

    public BehaviorState getBehavior() {
        Emotion priorityEmotion = getPriorityEmotion();
        if (priorityEmotion == SadEmotions.SAD){
            return behaviorStates.get(0);
        }
        if (priorityEmotion == HappyEmotions.HAPPY){
            return behaviorStates.get(1);
        }
        if (priorityEmotion == StoicEmotions.STOIC){
            return behaviorStates.get(2);
        }
        if (priorityEmotion == NervousEmotions.NERVOUS){
            return behaviorStates.get(3);
        }
        else {
            return  behaviorStates.get(4);
        }
    }
    public boolean addItem(Item item){
            return  container.addContent(item);
        }

    public boolean removeItem(Item item){
        return container.removeContent(item);
    }
    public boolean isAble(Emotion emotion){
        return !disableEmotion.contains(emotion);
    }
    public boolean addEmotion(Emotion emotion){
        if (emotions.contains(emotion)){
            System.out.println(getName()+" already feels "+ emotion);
            return false;
        }if(isAble(emotion)){
            System.out.println(getName() + "can't feel "+ emotion);
            return false;
        }else{
            return emotions.add(emotion);
        }
    }
    public boolean removeEmotion(Emotion emotion){
        if (emotions.contains(emotion)){
            System.out.println(getName()+" doesn't feel "+ emotion+ " anymore.");
            return emotions.remove(emotion);
        }else{
            System.out.println(getName()+" didn't feel "+ emotion);
            return false;
        }
    }
    public boolean addDisableEmotion(Emotion emotion){
        if (!isAble(emotion)){
            System.out.println(emotion+" already disable.");
            return false;
        }else{
            return disableEmotion.add(emotion);
        }
    }
    public boolean removeDisableEmotion(Emotion emotion){
        if (!disableEmotion.contains(emotion)){
            System.out.println(emotion+" already able.");
            return false;
        }else{
            System.out.println(emotion+" is able.");
            return disableEmotion.remove(emotion);
        }
    }

    public void setPose(Pose pose) {
        this.pose = pose;
    }
    public Pose getPose(){
        return pose;
    }
    public void setVoiceVolume(int volume){
        voiceVolume=volume;
    }

    public int getVoiceVolume() {
        return voiceVolume;
    }

    public boolean isEyesOpen() {
        return isEyesOpen;
    }

    public void setEyesOpen(boolean eyesOpen) {
        isEyesOpen = eyesOpen;
    }
    public boolean isEyesWet(){
        return isEyesWet;
    }

    public void setEyesWet(boolean eyesWet) {
        isEyesWet = eyesWet;
    }
    public boolean addView(Nameable nameable){
        if (view.contains(nameable)){
            System.out.println(getName()+" already sees "+ nameable.getName());
            return false;
        }else{
            return view.add(nameable);
        }
    }
    public boolean removeView(Nameable nameable){
        return view.remove(nameable); //TODO возможно сдлетаь чтобы печаталось что объект не было видно
    }
    public boolean addConflictCreature(Creature creature){
        if (conflictWith.contains(creature)){
            System.out.println(getName()+ " is already in conflict with "+ creature.getName());
            return false;
        }else{
            System.out.println(getName()+" is in conflict with "+ creature.getName());
            return conflictWith.add(creature);
        }
    }
}
