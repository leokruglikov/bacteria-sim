package app;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.*;
import org.jsfml.system.Clock;

public class App { 
    public static void main(String[] args) throws Exception { 
        
        RenderWindow main_wind = new RenderWindow(new VideoMode(1900, 1000),"Population" );
         main_wind.setFramerateLimit(60);
        ArrayList<food> f = new ArrayList<>();
        ArrayList<Bacteria_one> b = new ArrayList<>();
        ArrayList<Bacteria_one> almostB = new ArrayList<>();
        ArrayList<Bacteria_one> notB = new ArrayList<>();
        ArrayList<Bacteria_two> b2 = new ArrayList<>();
        ArrayList<Bacteria_two> almostB2 = new ArrayList<>();
        ArrayList<Bacteria_two> notB2 = new ArrayList<>();
        Clock FPStimer = new Clock();
        Clock Timer = new Clock();
        float lasttime=0;
        Text mytext= new Text();
        Text mytexttime = new Text();
        Font font = new Font();
        Path path = FileSystems.getDefault().getPath("C:\\Users\\emils\\Desktop\\Arial.ttf");
        font.loadFromFile(path);
        mytext.setFont(font);
        mytexttime.setFont(font);
        mytext.setPosition(10, 10);
        mytexttime.setPosition(15,30);
        Frame SimulationFrame = new Frame();
        String laiks;
        Graph graaphh = new Graph();
        Graph graph2 = new Graph();



        
        for(int i = 0; i<100; i++){
            f.add(new food());
        }

        for(int i = 0; i<50; i++){
            b.add(new Bacteria_one());
        }
        for(int i = 0; i<10; i++){
            b2.add(new Bacteria_two());
        }

        Clock BacteriaTimer = new Clock();

        while(main_wind.isOpen()){
        
            lasttime = FPStimer.getElapsedTime().asSeconds();
            for(Event ev : main_wind.pollEvents()){
                if(ev.type== Event.Type.CLOSED){
                    main_wind.close();
                }
                
            }
            for(int i = 0; i<20; i++){
               f.add(new food()); 
            }
            
                

            if(BacteriaTimer.getElapsedTime().asMilliseconds() >= 500.f){
                for(Bacteria_one bac : b){
                    bac.direction();
                    bac.hungry(false);
                }
                for(Bacteria_two bac : b2){
                    bac.direction();
                    bac.hungry(false);
                }
                BacteriaTimer.restart();
            }

            

            main_wind.display();
            main_wind.clear();
            for(food blob : f){
                blob.drawFood(main_wind);
            }
            
            for(Bacteria_one bac_one : b){
                bac_one.render(main_wind);
                bac_one.update_speed();
                bac_one.food_found(f, almostB);
                bac_one.decreaseAbility();
                if(bac_one.getAbility()<=0){
                    notB.add(bac_one);
                }
            }
            for(Bacteria_two bac_two : b2){
                bac_two.render(main_wind);
                bac_two.update_speed();
                bac_two.food_found(b, almostB2);
                bac_two.decreaseAbility();
                if(bac_two.getAbility()<=0){
                    notB2.add(bac_two);
                }
            }
            


            if(!almostB.isEmpty()){
                for(Bacteria_one bac_one : almostB){
                    Bacteria_one.addCount(1);
                    b.add(bac_one);
                }
                almostB.clear();
            }
            if(!almostB2.isEmpty()){
                for(Bacteria_two bac_two : almostB2){
                    b2.add(bac_two);
                }
                almostB2.clear();
            }

            if(!notB.isEmpty()){
                for(Bacteria_one bac_one : notB){
                    Bacteria_one.addCount(-1);
                    b.remove(bac_one);
                }
                notB.clear();
            }

            if(!notB2.isEmpty()){
                for(Bacteria_two bac_two : notB2){
                    b2.remove(bac_two);
                }
                notB2.clear();
            }
            
            
            if(Timer.getElapsedTime().asSeconds()>=0.5f){
                int fps = (int)(1.f/(FPStimer.getElapsedTime().asSeconds()-lasttime));
                laiks = Integer.toString(fps)+" fps";
                mytext.setString(laiks);
                Timer.restart();
            }
            graaphh.create(b.size(), main_wind,178 , 102, 255 , 60, b2.size(), 0, 255, 0, 50);
            graaphh.render(main_wind);
            graph2.render(main_wind);
            SimulationFrame.render(main_wind);
            main_wind.draw(mytext);
            main_wind.draw(mytexttime);
           

        }  
    } 
}