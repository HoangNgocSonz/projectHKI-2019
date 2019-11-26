package com.gamebase;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundManager {
    public static void play(String name){
        try{
            File f = new File(name);
            AudioInputStream stream = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
    } catch (Exception ex){
        ex.printStackTrace();}
    }
}
