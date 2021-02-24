package app;

import java.util.ArrayList;

import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;

public class Graph {

    protected Vector2f A;
    private float DORITOS;
    protected Vector2f B;
    protected Vector2f C;
    private Vertex[] v = new Vertex[3];
    private ArrayList<RectangleShape>  col = new ArrayList<>();
    private ArrayList<RectangleShape>  col2 = new ArrayList<>();
    private static float countscale = 0;
    private static float lastRatio = 1;
    private static float currentRatio = 0;
    private static float lastRatio2 = 1;
    private static float currentRatio2 = 0;

    
    public Graph (){
        A = new Vector2f(50, 780);
        B = new Vector2f(50, 950); //origin
        C = new Vector2f(1800, 950);
        this.v[0] = new Vertex(A);
        this.v[1] = new Vertex(B);
        this.v[2] = new Vertex(C);
        this.DORITOS = B.y - A.y;
} 

public void create(int num, RenderWindow w, int red , int g, int b , int alpha, int num2, int red2, int g2, int b2, int alpha2){
    RectangleShape gr = new RectangleShape();
    RectangleShape gr2 = new RectangleShape();
    if(num/DORITOS>num2/DORITOS){
        currentRatio = num/DORITOS;
    }
    else{
        currentRatio = num2/DORITOS;
    }
    gr.setFillColor( new Color(red, g, b,alpha));
    gr2.setFillColor( new Color(red2, g2, b2,alpha2));
    
        if(currentRatio<=1){
            if(lastRatio>0){
                gr.setSize(new Vector2f(2, num/lastRatio));
                gr.setPosition(new Vector2f(B.x + col.size(), B.y - gr.getSize().y));
                col.add(gr);
                gr2.setSize(new Vector2f(2, num2/lastRatio));
                gr2.setPosition(new Vector2f(B.x + col2.size(), B.y - gr2.getSize().y));
                col2.add(gr2);
            }
            else{
                gr.setSize(new Vector2f(2, num));
                gr.setPosition(new Vector2f(B.x + col.size(), B.y - gr.getSize().y));
                col.add(gr);
                gr2.setSize(new Vector2f(2, num2));
                gr2.setPosition(new Vector2f(B.x + col2.size(), B.y - gr2.getSize().y));
                col2.add(gr2);
            }
        }
        else{
            if(lastRatio< currentRatio){
                for(int i = 0; i < col.size(); i++){
                    col.get(i).setSize(new Vector2f(col.get(i).getSize().x, (col.get(i).getSize().y*lastRatio)));
                    col.get(i).setSize(new Vector2f(col.get(i).getSize().x, (col.get(i).getSize().y/currentRatio)));
                    col.get(i).setPosition(B.x + i + 1, B.y - col.get(i).getSize().y);
                }
                for(int i = 0; i < col2.size(); i++){
                    col2.get(i).setSize(new Vector2f(col2.get(i).getSize().x, (col2.get(i).getSize().y*lastRatio)));
                    col2.get(i).setSize(new Vector2f(col2.get(i).getSize().x, (col2.get(i).getSize().y/currentRatio)));
                    col2.get(i).setPosition(B.x + i + 1, B.y - col2.get(i).getSize().y);
                }
                gr.setSize(new Vector2f(2, num/currentRatio));
                gr.setPosition(new Vector2f(B.x + col.size(), B.y - gr.getSize().y));
                col.add(gr);
                gr2.setSize(new Vector2f(2, num2/currentRatio));
                gr2.setPosition(new Vector2f(B.x + col2.size(), B.y - gr2.getSize().y));
                col2.add(gr2);
                lastRatio = currentRatio;
            }
            else{
                gr.setSize(new Vector2f(2, num/lastRatio));
                gr.setPosition(new Vector2f(B.x + col.size(), B.y - gr.getSize().y));
                col.add(gr);
                gr2.setSize(new Vector2f(2, num2/lastRatio));
                gr2.setPosition(new Vector2f(B.x + col2.size(), B.y - gr2.getSize().y));
                col2.add(gr2);
            }
        }
   
        if(col.get(col.size()-1).getPosition().x > C.x){
            col.clear();
            gr.setPosition(new Vector2f(B.x + col.size(), B.y - gr.getSize().y));
            col.add(gr);
            col2.clear();
            gr2.setPosition(new Vector2f(B.x + col2.size(), B.y - gr2.getSize().y));
            col2.add(gr2);
        } 


        for (RectangleShape r : col) {
            w.draw(r);
        }

        for(RectangleShape r2 :col2){
            w.draw(r2);
        }
    
}


public void render(RenderWindow w){
    w.draw(v, PrimitiveType.LINE_STRIP);
}




}