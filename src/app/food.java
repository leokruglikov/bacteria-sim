package app;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

public class food {
    private CircleShape food;
    private int R;
    private int G;
    private int B;
    private Color color;

    public food(){
        food = new CircleShape();
        this.food.setRadius(1f);
        this.food.setPointCount(10);
        this.food.setPosition(new Vector2f(((float)Math.random()*1860)+15, ((float)Math.random()*660)+15));
        this.food.setOrigin(new Vector2f(food.getRadius(),food.getRadius()));
        R = (int)(Math.random()*256);
        G = (int)(Math.random()*256);
        B= (int)(Math.random()*256);
        color = new Color(R, G, B);
        this.food.setFillColor(color);
    }

    public Vector2f getPos(){
        return this.food.getPosition();
    }

    public void drawFood(RenderWindow main_wind){
            main_wind.draw(food);
    }

    public CircleShape getNuttedOnBitch(){
        return this.food;
    }



}