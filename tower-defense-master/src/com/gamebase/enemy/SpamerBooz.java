package com.gamebase.enemy;

import com.gamebase.ClockFrame;
import com.gamebase.Value;

import java.awt.*;

public class SpamerBooz {


    public static Boos[] mobs =new Boos[100];
    public static int spamtime =1 ; // giay/con
    public SpamerBooz(){
        for (int i = 0; i < mobs.length; i++) {
            mobs[i] = new Boos();

        }
    }
    public  void physic(){
        for (int i = 0; i < mobs.length; i++) {
            if (mobs[i].inGame)
                mobs[i].physic();

        }
    }
    public void modSpamer(Point SpamPoint){

        if ((ClockFrame.CountTick()%spamtime==spamtime-1)&&(ClockFrame.NextTick())) {
            for (int i = 0; i < mobs.length; i++) {
                if (!mobs[i].inGame) {
//                    int id =(int)(Math.random()*4);
                    mobs[i].spawnMod(Value.mobSodi, SpamPoint);
                    break;
                }
            }
//            frametime=0;
//        }else frametime++;
        }
        physic();
    }

    public void draw(Graphics g){
        for (int i = 0; i < mobs.length ; i++) {
            if(mobs[i].inGame){
                mobs[i].draw(g);
            }
        }
    }
}