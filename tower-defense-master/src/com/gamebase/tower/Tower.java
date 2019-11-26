package com.gamebase.tower;

import com.gamebase.Block;

import com.gamebase.etity.amo;

import javax.swing.*;
import java.awt.*;

public abstract class  Tower extends Block implements physic {
    public int Range;
    public int xCenter,yCenter;
    public boolean isFight =false;
    public boolean isFight2 =false;
    public int fightId=-1;
    public int fightId2=-1;
    public amo bullet ;
    public amo bullet2;


    public  Tower(Block a) {
        super(a.x, a.y, a.width, a.height, a.groundID, a.airID);
        this.xCenter= x+width/2;
        this.yCenter= y+height/2;
        this.hasTower=true;
        bullet = new amo(xCenter,yCenter);
        bullet2 = new amo(xCenter,yCenter);
    }
    public abstract boolean insideRange(int x,int y);
    public abstract void fightingMob(Graphics g);
    public abstract void subHeal();
    public abstract void ShootingRange(Graphics g);
    public abstract void draw(Graphics g);
}
