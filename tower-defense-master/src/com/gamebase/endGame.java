package com.gamebase;

import javax.swing.*;
import java.awt.*;

public class endGame {
    Image image = new ImageIcon("res/gameOver.jpg").getImage();
    public  void draw(Graphics g){
        g.drawImage(image,150,70,700,500,null);
    }
}
