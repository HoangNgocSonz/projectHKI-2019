package com.gamebase;

import javax.swing.*;
import java.awt.*;

public class start {
    Image image = new ImageIcon("res/start2-removebg-preview.png").getImage();
    public  void draw(Graphics g){
        g.drawImage(image,270,150,400,300,null);
    }
}
