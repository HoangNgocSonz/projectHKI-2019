package com.gamebase;
import com.gamebase.enemy.SpamerBooz;
import com.gamebase.etity.SpamerMob;

import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.time.Clock;

public class Screen extends JPanel implements Runnable{
    int x=0;int y=0;
    public static int run =0;
    public static int enemyDie = 0;
    public Thread thread = new Thread(this);
    public static boolean isFirst = true;
    public static Image[] tileset_ground = new Image[50];
    public static Image[] tileset_air = new Image[50];
    public static Image[] tileset_tower = new Image[50];
    public static Image[] tileset_res = new Image[50];
    public static Image[] tileset_mod=new Image[50];
    Value value =new Value();
    public static endGame end;
    public static start st;


    public static int myWidth, myHeight,coin=1000,heart=3;

    public static Room room;
    public static Save save;
    public static  Store store;
    public static SpamerBooz spamerBooz;
    public static SpamerMob spamerMob;

//    public static Mob[] mobs =new Mob[100];
    public static Point mse =new Point(0, 0);

    public Screen( Frame frame){
        frame.addMouseListener(new KeyHandel());
        frame.addMouseMotionListener(new KeyHandel());
        thread.start();
    }

    public void define(){
        st=new start();
        end=new endGame();
        room = new Room();
        save = new Save();
        store = new Store();
//        for (int i = 0; i < mobs.length; i++) {
//            mobs[i] = new Mob();
//
//        }
        spamerBooz=new SpamerBooz();
        spamerMob=new SpamerMob();

        tileset_ground[0] = new ImageIcon("res/grass.png").getImage();
        //tileset_ground[0] = createImage(new FilteredImageSource( tileset_ground[0].getSource(),new CropImageFilter(0,0*26,26,26)));
        tileset_ground[1] = new ImageIcon("res/towerDefense_tile181.png").getImage();
        //tileset_ground[1] = createImage(new FilteredImageSource( tileset_ground[1].getSource(),new CropImageFilter(0,1*26,26,26)));
        tileset_ground[2]=new ImageIcon("res/mapTile_100.png").getImage();
        tileset_ground[3]=new ImageIcon("res/road.png").getImage();

        tileset_air[0]=new ImageIcon("res/mapTile_099.png").getImage();
        tileset_air[1]=new ImageIcon("res/towerDefense_tile130.png").getImage();
        tileset_air[2]=new ImageIcon("res/towerDefense_tile131.png").getImage();
        tileset_air[3]=new ImageIcon("res/housejpg-removebg-preview.png").getImage();
        tileset_air[4]=new ImageIcon("res/game-tree-sprite-2d-computer-graphics-amazon-rainforest-clipart-removebg-preview.png").getImage();
        tileset_air[5]=new ImageIcon("res/tre.png").getImage();

        tileset_res[0] = new ImageIcon("res/cell.png").getImage();
        tileset_res[1] = new ImageIcon("res/cell_shadow.png").getImage();
        tileset_res[2] = new ImageIcon("res/coins.png").getImage();
        tileset_res[3] = new ImageIcon("res/heart.png").getImage();

        tileset_mod[0] = new ImageIcon("res/mapTile_136.png").getImage();
        tileset_mod[1] = new ImageIcon("res/mapTile_137.png").getImage();
        tileset_mod[2] = new ImageIcon("res/mapTile_153.png").getImage();
        tileset_mod[3] = new ImageIcon("res/mapTile_154.png").getImage();
        tileset_mod[4] = new ImageIcon("res/mapTile_170.png").getImage();

        tileset_tower[0] = new ImageIcon("res/gunTower-removebg-preview.png").getImage();
        tileset_tower[1] = new ImageIcon("res/lazeTower-removebg-preview (1).png").getImage();
        tileset_tower[2] = new ImageIcon("res/lazeTower-removebg-preview (1).png").getImage();

        save.loadSave(new File("save/mission1"));
        //System.out.println(Value.endX+""+Value.endY);

        room.physic(Value.endX,Value.endY);
    }
    public void paintComponent(Graphics g){
        if (isFirst) {
            myHeight=getHeight();
            myWidth=getWidth();
            define();
            isFirst = false;
        }
        g.setColor(new Color(20,100,30));
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(new Color(0,0,0));
        g.drawLine(room.blocks[0][0].x-1,0,room.blocks[0][0].x-1,
                room.blocks[room.worldHeight-1][0].y+room.blocksize);
        g.drawLine(room.blocks[0][room.worldWidth-1].x + room.blocksize +1,0,
                room.blocks[0][room.worldWidth-1].x + room.blocksize +1,
                room.blocks[room.worldHeight-1][0].y+room.blocksize);

        room.draw(g);// ve room;
        spamerBooz.draw(g);
        spamerMob.draw(g);
        if(heart<=0)
            end.draw(g);
        store.draw(g); // ve shop;
        if(run==0){
            st.draw(g);
        }
    }

    int delay=0;
    //public static int fpsframe =0 ,fps =10000000;
    @Override
    public void run() {
        ClockFrame.StartTime();
        long timeStart = System.currentTimeMillis();
        while (true){
            long currentTime=System.currentTimeMillis();
            if (!isFirst){
                if(heart>0 && run==1){
                    spamerMob.modSpamer(new Point(0,1));
                }
            }
            ClockFrame.NowTime();
            repaint();

            try {
                Thread.sleep(1);
            }catch (Exception e){

            }
        }
    }
    public static void click(int mouseId){
        //System.out.println("q");
        if(mouseId==1){
//            x=mse.x;
//            y=mse.y;
            if(mse.x>270 && mse.x<670 && mse.y>150&& mse.y<450){
                run=1;
            }
        }

    }
}

