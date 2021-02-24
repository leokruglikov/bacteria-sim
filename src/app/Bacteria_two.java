package app;

import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import java.util.ArrayList;

public class Bacteria_two extends Frame{
    private CircleShape body = new CircleShape();
    private CircleShape eye = new CircleShape();
    private CircleShape mouth= new CircleShape();
    private Vertex tail[]= new Vertex[3];
    private static int count=0;
    private boolean visibility = true;
    private float r = 7.f;
    private boolean ifLookForBacteria=false;
    private float velocityX=0.f;
    private float velocityY=0.f;
    private float velocity = 7f;
    private float visionR=150.f;
    private double angle;
    private float ability;
    private boolean ifLookForFood = false;

    private void set_tail(){
        this.tail[0] = new Vertex(new Vector2f( (this.body.getPosition().x-this.body.getRadius()*0.5f) , this.body.getPosition().y), new Color(51, 204, 51) );
        this.tail[1] = new Vertex(new Vector2f( (this.body.getPosition().x+this.body.getRadius()*0.5f) , this.body.getPosition().y), new Color(51, 204, 51) );
        this.tail[2] = new Vertex(new Vector2f( this.body.getPosition().x , this.body.getPosition().y + 2*this.body.getRadius()), new Color(51, 204, 51) );
    }

    public Bacteria_two(){
        this.body.setRadius(r);
        this.body.setPosition(new Vector2f((float)Math.random()*1950, (float)Math.random()*1100));
        this.body.setPointCount(15);
        this.body.setOrigin(body.getRadius(), body.getRadius());
        this.body.scale(0.5f,1.f);
        this.body.setFillColor(new Color(51, 204, 51));
        this.mouth.setRadius(body.getRadius()/3);
        this.mouth.setPointCount(3);
        this.mouth.setFillColor(new Color(0, 0, 102));
        this.mouth.setOrigin(new Vector2f(mouth.getRadius(), mouth.getRadius()));
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getRadius()/4));
        this.mouth.rotate(60.f);
        this.eye.setPointCount(10);
        this.eye.setRadius(this.body.getRadius()/10.f);
        this.eye.setFillColor(Color.BLACK);
        this.eye.setOutlineColor(Color.RED);
        this.eye.setOutlineThickness(this.eye.getRadius());
        this.eye.setOrigin(new Vector2f(eye.getRadius(), eye.getRadius()));
        this.eye.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y - this.body.getRadius()/3));
        set_tail();
        this.ability = 5f;
    }

    public Bacteria_two(float x, float y ){
        this.body.setRadius(r);
        this.body.setPosition(new Vector2f(x, y));
        this.body.setPointCount(15);
        this.body.setOrigin(body.getRadius(), body.getRadius());
        this.body.scale(0.5f,1.f);
        this.body.setFillColor(new Color(51, 204, 51));
        this.mouth.setRadius(body.getRadius()/3);
        this.mouth.setPointCount(3);
        this.mouth.setFillColor(new Color(0, 0, 102));
        this.mouth.setOrigin(new Vector2f(mouth.getRadius(), mouth.getRadius()));
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getRadius()/4));
        this.mouth.rotate(60.f);
        this.eye.setPointCount(10);
        this.eye.setRadius(this.body.getRadius()/10.f);
        this.eye.setFillColor(Color.BLACK);
        this.eye.setOutlineColor(Color.RED);
        this.eye.setOutlineThickness(this.eye.getRadius());
        this.eye.setOrigin(new Vector2f(eye.getRadius(), eye.getRadius()));
        this.eye.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y - this.body.getRadius()/3));
        set_tail();
        this.ability = 5f;

    }

    public void set_b_position(float x , float y){
        this.body.setPosition(x, y);
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getRadius()/4));
        this.eye.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y - this.body.getRadius()/3));
        set_tail();
    }

    public void set_b_size(float R){
        this.body.setRadius(R);
        this.body.setOrigin(R , R);
        this.mouth.setRadius(this.body.getRadius()/3);
        this.mouth.setOrigin(new Vector2f(mouth.getRadius(), mouth.getRadius()));
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getRadius()/4));
        this.eye.setRadius(this.body.getRadius()/10.f);
        this.eye.setOrigin(new Vector2f(eye.getRadius(), eye.getRadius()));
        this.eye.setOutlineThickness(this.eye.getRadius());
        this.eye.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y - this.body.getRadius()/3));
        set_tail();
    }
    public void set_b_position(Vector2f pos){
        this.body.setPosition(pos);
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getRadius()/4));
        this.eye.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y - this.body.getRadius()/3));
        set_tail();
    }

    public void increment_b_position(){
        this.body.setPosition(this.body.getPosition().x+this.velocityX, this.body.getPosition().y+this.velocityY);
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getRadius()/4));
        this.eye.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y - this.body.getRadius()/3));
        set_tail();
    }

    public Vector2f get_position(){ return this.body.getPosition();}
    public float get_big_radius(){ return this.body.getRadius(); }

    
    public void render(RenderWindow wind){
        if (visibility) {
            wind.draw(this.body);
            wind.draw(tail, PrimitiveType.TRIANGLES);
            wind.draw(this.mouth);
            wind.draw(this.eye);
        }
    }
    public void direction(){ //random speed
        if(ifLookForBacteria == false){
            this.angle = Math.random()*2*Math.PI;
            this.velocityX = (float)(velocity*Math.cos(angle));
            this.velocityY = (float)(velocity*Math.sin(angle));
        }
    }

    public void food_found(ArrayList<Bacteria_one> b, ArrayList<Bacteria_two> almostB2){        //rīkojamies , ja ēdiens ir atrasts
        increment_b_position();                         //refactor !!!!!!!!!!!!
        if(this.ifLookForFood == false){
            if(look_for_food(b) != null){               //parbaudam vai ir redzes loka
                float xD = look_for_food(b).get_b_position().x - this.body.getPosition().x;
                float yD = look_for_food(b).get_b_position().y - this.body.getPosition().y;
                float vec = (float)Math.sqrt(Math.pow(xD, 2)+Math.pow(yD, 2));
                float scalar = vec/velocity;
                this.velocityX = xD/scalar;
                this.velocityY = yD/scalar;
                this.ifLookForFood = true;
                
            }
            
        }
        else{       //kad iet pie ediena ieejam un parbaudam vai saskaras
            
            if(look_for_food(b) != null){     //vai ēdiens eksistē
                if(this.body.getGlobalBounds().intersection(look_for_food(b).edpimpi().getGlobalBounds()) != null){

                    ability+= look_for_food(b).getAbility();
                    this.ifLookForFood = false;
                    b.remove(look_for_food(b)); //aped edienu un ediens pazud
                }
            }
            else{   //ēdiens vairs nav tur, tatad nemekle 
                this.ifLookForFood = false;
            }
        }
        if(ability >= 10){
            almostB2.add(new Bacteria_two(this.body.getPosition().x+10, this.body.getPosition().y+10));
            ability /= 3;
        }



    }

    public void hungry(boolean is){
        this.ifLookForFood = is;
    }

    public Bacteria_one look_for_food( ArrayList<Bacteria_one> b){    //meklesim NUT
        float distanceFood = 0;                            //inicializējam , lai atrstu tuvāko ēdienu jeb ar mazāko distanci
        Bacteria_one smallestFood = null;                  //tam tuvkajam ēdienam indekss , ja indekss paliek -1, tad nav neko atradis!
        float smallestDistance = visionR+50.f; 
        for (Bacteria_one bac : b) {
            distanceFood = (float)Math.sqrt(Math.pow(bac.get_b_position().x-this.body.getPosition().x, 2)+Math.pow(bac.get_b_position().y-this.body.getPosition().y, 2));
            if(distanceFood <= visionR){            //parbaudam vai atrodas redzes lokā
                if(distanceFood<smallestDistance){   //pārbaudam vai tas atrastais ir mazākais 
                    smallestDistance = distanceFood;
                    smallestFood = bac;
                }
            }
        }
        return smallestFood;
        
}









    public void update_speed(){

        if(this.body.getPosition().x - this.body.getRadius()/2 <= super.A.x){ //parbaudam pa kreisi (A atrodas augsa pa kreisi)
            this.velocityX *= -1;
            this.body.setPosition(new Vector2f(A.x+this.body.getRadius()/2, this.body.getPosition().y));
        };

        if(this.body.getPosition().y - this.body.getRadius()/2 <= super.A.y){ //parbaudam augsaa (A atrodas augsa pa kreisi)
            this.velocityY *= -1;
            this.body.setPosition(new Vector2f(this.body.getPosition().x , A.y+ this.body.getRadius()/2));
        };

        if(this.body.getPosition().x + this.body.getRadius()/2 >= super.D.x){ //parbaudam pa labi (B atrodas pa labi augsa)
            this.velocityX *= -1;
            this.body.setPosition(new Vector2f(D.x - this.body.getRadius()/2, this.body.getPosition().y));
        };

        if(this.body.getPosition().y + this.body.getRadius()/2 >= super.B.y){ //parbaudam leja ()
            this.velocityY *= -1;
            this.body.setPosition(new Vector2f(this.body.getPosition().x , B.y - this.body.getRadius()/2));
        };

    }

    public float getAbility(){
        return this.ability;
    }

    public void decreaseAbility(){
        this.ability -=0.05;
    }

    






}
