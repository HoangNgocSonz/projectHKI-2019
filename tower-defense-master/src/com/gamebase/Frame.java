package com.gamebase;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static String title = " tower game ... ? ";
    public static Dimension size = new Dimension(1040, 720);
    public Frame(){
        setTitle(title);
        setSize(size);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }
    public void init(){
        setLayout(new GridLayout(1,1,0,0));
        Screen screen =new Screen(this);
        add(screen);
        setVisible(true);
    }
    public static void main(String args[]){
        Sound_cdjv sound=new Sound_cdjv("res/nen.wav");
        sound.start();
        Frame frame = new Frame();

    }
}
