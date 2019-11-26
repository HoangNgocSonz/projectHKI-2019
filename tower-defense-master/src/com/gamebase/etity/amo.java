package com.gamebase.etity;

import com.gamebase.ClockFrame;

import javax.swing.*;
import java.awt.*;

public class amo extends Point{
    Image tileset_amo ;
    public int rVaCham=8;
    public boolean shootingAmo =false;
    public boolean shootingAmo2 =false;
    //    public int time;
    public amo(int x,int y){
        setLocation(x,y);
        this.tileset_amo = new ImageIcon("res/rsz_1rsz_bullet_circle-removebg-preview.png").getImage();
    }
    public void delete(int xTower, int yTower){
        this.x=xTower;
        this.y=yTower;
    }
    public int t;

public void physic(int x,int y,int speedAmo){
    if ((t >=speedAmo)) {

        if (this.x >= x&&this.y>=y) {
            this.x-=1;
            this.y-=1;
            if(this.x-x>this.y-y) this.x--;

            if(this.x-x<=this.y-y) this.y--;

        }
        if (this.x >= x && this.y<=y) {
            this.x--;
            this.y++;
            if(this.x-x>y-this.y) this.x--;

            if(this.x-x<=y-this.y) this.y++;
        }
        if (this.x<=x && this.y>=y) {
            this.x++;
            this.y--;
            if(x-this.x>this.y-y) this.x++;
            if(x-this.x<=this.y-y) this.y--;
        }
        if (this.x <=x && this.y<=y) {
            this.x++;
            this.y++;
            if(x-this.x>y-this.y) this.x++;
            if(x-this.x<=y-this.y) this.y++;
        }

        t=0;
    }else t++;
}
    public boolean vaCham(int xMob, int yMob){
        if(xMob<this.x && yMob<this.y && this.x-xMob<rVaCham && this.y-yMob<rVaCham){
            return true;
        }
        else if(xMob<this.x && yMob>=this.y && this.x-xMob<rVaCham && yMob-this.y<rVaCham){
            return true;
        }
        else if(xMob>=this.x && yMob<this.y && xMob-this.x<rVaCham && this.y-yMob<rVaCham){
            return true;
        }
        else if(xMob>=this.x && yMob>=this.y && xMob-this.x<rVaCham && yMob-this.y<rVaCham){
            return true;
        }
//        if(this.x==xMob && this.y==yMob) return true;
        else return false;
    }
    public void draw(Graphics g){
        g.drawImage(tileset_amo,x-5,y-20,10,10,null);
    }
}
