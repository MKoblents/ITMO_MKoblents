package state;

import interfaces.Emotion;

import java.util.ArrayList;

public abstract class State {
    private ArrayList<Emotion> emotions;
    private ArrayList<Emotion> disableEmotion;

    public ArrayList<Emotion> getEmotions(){return emotions;}

    public ArrayList<Emotion> getDisableEmotion() {return disableEmotion;}

    public void setEmotions(ArrayList<Emotion> emotions) {
        this.emotions = emotions;
    }

    public void setDisableEmotion(ArrayList<Emotion> disableEmotion) {
        this.disableEmotion = disableEmotion;
    }
}
