package com.gamebase.tower;

import com.gamebase.Block;
import com.gamebase.Screen;
import com.gamebase.Value;
import com.gamebase.enemy.Boos;
import com.gamebase.enemy.SpamerBooz;
import com.gamebase.etity.Mob;
import com.gamebase.etity.SpamerMob;
import javax.swing.*;
import java.awt.*;

public class GunTower extends Tower{
    private Image tileset_tower1 ;

    public GunTower(Block a) {
        super(a);
        tileset_tower1= new ImageIcon("res/gunTower-removebg-preview.png").getImage();
        Range=4*40;
    }
    public boolean insideRange(int x,int y){
        if(Math.pow(x-xCenter,2)+Math.pow(y-yCenter,2)-Math.pow(Range/2,2)<=0) return true;
        return false;
    }
    public void fightingMob(Graphics g){
        //enemy1
        for (int i = 0; i < SpamerMob.mobs.length; i++) {
            if (SpamerMob.mobs[i].inGame){
                    if (insideRange(SpamerMob.mobs[i].x+ Mob.mobSize/2,SpamerMob.mobs[i].y+Mob.mobSize/2)){
                    isFight =true;
                    fightId =i;
                    break;
                } else {
                    isFight =false;
                }
            }
        }
        try {
            if (isFight) {
                bullet.shootingAmo = true;
                SpamerMob.mobs[fightId].isShooting =true;
            }else {
                bullet.shootingAmo =false;
                SpamerMob.mobs[fightId].isShooting =false;
            }
            if(bullet.vaCham(SpamerMob.mobs[fightId].x +1+Mob.mobSize / 2, SpamerMob.mobs[fightId].y+1 + Mob.mobSize / 2)){
                bullet.delete(xCenter,yCenter);
                subHeal();
                bullet.shootingAmo=false;
            }
            if (!insideRange(SpamerMob.mobs[fightId].x+Mob.mobSize/2,SpamerMob.mobs[fightId].y+Mob.mobSize/2)){
                bullet.delete(xCenter,yCenter);
            }
            if (bullet.shootingAmo)  bullet.physic(SpamerMob.mobs[fightId].x +1+Mob.mobSize / 2, SpamerMob.mobs[fightId].y+1 + Mob.mobSize / 2,0);

            if(bullet.shootingAmo)  bullet.draw(g);
        }catch (Exception e) {}

        //enemy2
//        for (int i = 0; i < SpamerBooz.mobs.length; i++) {
//            if (SpamerBooz.mobs[i].inGame){
//                if (insideRange(SpamerBooz.mobs[i].x+ Mob.mobSize/2,SpamerBooz.mobs[i].y+Mob.mobSize/2)){
//                    isFight =true;
//                    fightId =i;
//                    break;
//                } else {
//                    isFight =false;
//                }
//            }
//        }
//        try {
//            if (isFight) {
//                bullet.shootingAmo = true;
//                SpamerBooz.mobs[fightId].isShooting =true;
//            }else {
//                bullet.shootingAmo =false;
//                SpamerBooz.mobs[fightId].isShooting =false;
//            }
//            if(bullet.vaCham(SpamerBooz.mobs[fightId].x +1+Mob.mobSize / 2, SpamerBooz.mobs[fightId].y+1 + Mob.mobSize / 2)){
//                bullet.delete(xCenter,yCenter);
//                subHeal();
//                bullet.shootingAmo=false;
//            }
//            if (!insideRange(SpamerBooz.mobs[fightId].x+Mob.mobSize/2,SpamerBooz.mobs[fightId].y+Mob.mobSize/2)){
//                bullet.delete(xCenter,yCenter);
//            }
//            if (bullet.shootingAmo)  bullet.physic(SpamerBooz.mobs[fightId].x +1+Mob.mobSize / 2, SpamerBooz.mobs[fightId].y+1 + Mob.mobSize / 2,0);
//
//            if(bullet.shootingAmo)  bullet.draw(g);
//        }catch (Exception e) {}
    }

    @Override
    public void subHeal() {
        SpamerMob.mobs[fightId].heathMob--;
        SpamerMob.mobs[fightId].mobDie();

//        SpamerBooz.mobs[fightId].heathMob--;
//        SpamerBooz.mobs[fightId].mobDie();
    }

    @Override
    public void ShootingRange(Graphics g) {
        g.drawOval(xCenter-Range/2,yCenter-Range/2,Range,Range);
    }

    public void draw(Graphics g){
        g.drawImage(Screen.tileset_ground[Value.groundGrass],x,y,width,height,null);
        //g.drawImage(Screen.tileset_ground[groundID],x,y,width,height,null);
        g.drawImage(tileset_tower1,x,y,width,height,null);
        //g.drawRect(x,y,width,height);

        if(airID>-1){
            g.drawImage(Screen.tileset_air[airID],x-height*3*width/(y) ,y-(x+y)/(x-y),width,height,null);
        }
    }
}
