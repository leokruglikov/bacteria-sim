package app;

import org.jsfml.graphics.*;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import java.util.ArrayList;

public class Bacteria_one extends Frame{
        /*
        private variables
         */
        private static int count=0;
        private RectangleShape body= new RectangleShape();
        private CircleShape eye1=new CircleShape();
        private CircleShape eye2 = new CircleShape();
        private RectangleShape mouth = new RectangleShape();
        private Vertex t[]=new Vertex[8];
        private boolean visibility = true;
        private float vision_r=150.f;
        private float velocity;
        private double angle;
        private float velocity_x=0.f;
        private float velocity_y=0.f;
        private boolean ifLookForFood = false;
        private float ability;
        private Clock private_clock;

        /*
        private methods
         */

        private void set_teeth(){
            float delta;
            delta=this.mouth.getSize().x/(4);

            t[0] = new Vertex(new Vector2f(((this.mouth.getPosition().x-this.mouth.getSize().x/2) + delta) , this.mouth.getPosition().y - this.mouth.getSize().y/2), Color.BLACK);
            t[1]= new Vertex(new Vector2f(((this.mouth.getPosition().x-this.mouth.getSize().x/2) + delta) , this.mouth.getPosition().y + this.mouth.getSize().y/2), Color.BLACK);
            t[2] = new Vertex(new Vector2f( ((this.mouth.getPosition().x-this.mouth.getSize().x/2) + 2*delta) , this.mouth.getPosition().y - this.mouth.getSize().y/2) , Color.BLACK);
            t[3]= new Vertex(new Vector2f(((this.mouth.getPosition().x-this.mouth.getSize().x/2) + 2*delta) , this.mouth.getPosition().y + this.mouth.getSize().y/2), Color.BLACK);
            t[4]= new Vertex(new Vector2f(((this.mouth.getPosition().x-this.mouth.getSize().x/2) + 3*delta) , this.mouth.getPosition().y - this.mouth.getSize().y/2), Color.BLACK);
            t[5]= new Vertex(new Vector2f( ((this.mouth.getPosition().x-this.mouth.getSize().x/2) + 3*delta) , this.mouth.getPosition().y + this.mouth.getSize().y/2), Color.BLACK);
            t[6]= new Vertex(new Vector2f(this.mouth.getPosition().x- this.mouth.getSize().x/2 , this.mouth.getPosition().y ), Color.BLACK);
            t[7]= new Vertex(new Vector2f(this.mouth.getPosition().x+ this.mouth.getSize().x/2 , this.mouth.getPosition().y ), Color.BLACK);


        }



        /*
        public methods
         */


    public Bacteria_one(){
        //initializing the body, setting the origin at the center
        this.body.setSize(new Vector2f(4, 6));
        // this.body.setPosition(new Vector2f(x,y));
        this.body.setPosition(new Vector2f(((float)Math.random()*1860)+15, ((float)Math.random()*660)+15));
        this.body.setFillColor(new Color(178, 102, 255));
        this.body.setOrigin(body.getSize().x/2 , body.getSize().y/2);
        //initializing the eyes
        this.eye1.setPointCount(10);
        this.eye1.setRadius(this.body.getSize().x/15.f);
        this.eye1.setFillColor(Color.BLACK);
        this.eye1.setOutlineColor(Color.WHITE);
        this.eye1.setOutlineThickness(this.eye1.getRadius());
        this.eye1.setOrigin(new Vector2f(eye1.getRadius(), eye1.getRadius()));
        this.eye2.setPointCount(10);
        this.eye2.setRadius(this.body.getSize().x/15.f);
        this.eye2.setFillColor(Color.BLACK);
        this.eye2.setOutlineColor(Color.WHITE);
        this.eye2.setOutlineThickness(this.eye2.getRadius());
        this.eye2.setOrigin(new Vector2f(eye1.getRadius(), eye1.getRadius()));
        this.eye1.setPosition(new Vector2f(this.body.getPosition().x+this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        this.eye2.setPosition(new Vector2f(this.body.getPosition().x-this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        //initializing the mouth
        this.mouth.setSize(new Vector2f(this.body.getSize().x/2, this.body.getSize().y/4 ));
        this.mouth.setOrigin(new Vector2f(this.mouth.getSize().x/2, this.mouth.getSize().y/2));
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getSize().y/5));
        //initializing teeth
        set_teeth();
        //initializing speed
        this.velocity = 10f;
        this.angle = Math.random()*2*Math.PI;
        this.velocity_x = 0;//(float)(velocity*Math.cos(angle));
        this.velocity_y = 0;//(float)(velocity*Math.sin(angle));
        this.ability=2.f;
        count++;
    }

        //Overload
    public Bacteria_one(float x, float y){
        //initializing the body, setting the origin at the center
        this.body.setSize(new Vector2f(4,6));
        this.body.setPosition(new Vector2f(x,y));
        // this.body.setPosition(new Vector2f((float)Math.random()*1950, (float)Math.random()*1100));
        this.body.setFillColor(new Color(178, 102, 255));
        this.body.setOrigin(body.getSize().x/2 , body.getSize().y/2);
        //initializing the eyes
        this.eye1.setPointCount(10);
        this.eye1.setRadius(this.body.getSize().x/15.f);
        this.eye1.setFillColor(Color.BLACK);
        this.eye1.setOutlineColor(Color.WHITE);
        this.eye1.setOutlineThickness(this.eye1.getRadius());
        this.eye1.setOrigin(new Vector2f(eye1.getRadius(), eye1.getRadius()));
        this.eye2.setPointCount(10);
        this.eye2.setRadius(this.body.getSize().x/15.f);
        this.eye2.setFillColor(Color.BLACK);
        this.eye2.setOutlineColor(Color.WHITE);
        this.eye2.setOutlineThickness(this.eye2.getRadius());
        this.eye2.setOrigin(new Vector2f(eye1.getRadius(), eye1.getRadius()));
        this.eye1.setPosition(new Vector2f(this.body.getPosition().x+this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        this.eye2.setPosition(new Vector2f(this.body.getPosition().x-this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        //initializing the mouth
        this.mouth.setSize(new Vector2f(this.body.getSize().x/2, this.body.getSize().y/4 ));
        this.mouth.setOrigin(new Vector2f(this.mouth.getSize().x/2, this.mouth.getSize().y/2));
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getSize().y/5));
        //initializing teeth
        set_teeth();
        //initializing speed
        this.velocity = 10f;
        this.angle = Math.random()*2*Math.PI;
        this.velocity_x = 0;// (float)(velocity*Math.cos(angle));
        this.velocity_y = 0;//(float)(velocity*Math.sin(angle));
        this.ability=2.f;
        
        count++;
    }

    public void render(RenderWindow wind){
        
        if (visibility) {
            wind.draw(this.body);
            wind.draw(this.eye1);
            wind.draw(this.eye2);
            wind.draw(this.mouth);
            wind.draw(t, PrimitiveType.LINES);
        }
    }

    public void direction(){ //random speed
        if(ifLookForFood == false){
            this.angle = Math.random()*2*Math.PI;
            this.velocity_x = (float)(velocity*Math.cos(angle));
            this.velocity_y = (float)(velocity*Math.sin(angle));
        }
    }

    public RectangleShape edpimpi(){
        return this.body;
    }

    public void set_b_position(float x , float y){
            this.body.setPosition(x, y);
            this.eye1.setPosition(new Vector2f(this.body.getPosition().x+this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
            this.eye2.setPosition(new Vector2f(this.body.getPosition().x-this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
            this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getSize().y/5));
            set_teeth();
    }
    public void set_b_size(float w, float h){
        this.body.setSize(new Vector2f(w, h));
        this.body.setOrigin(body.getSize().x/2 , body.getSize().y/2);
        this.eye1.setRadius(w/15.f);
        this.eye1.setOrigin(new Vector2f(eye1.getRadius(), eye1.getRadius()));
        this.eye1.setPosition(new Vector2f(this.body.getPosition().x+this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        this.eye1.setOutlineThickness(this.eye1.getRadius());
        this.eye2.setRadius(w/15.f);
        this.eye2.setOrigin(new Vector2f(eye1.getRadius(), eye1.getRadius()));
        this.eye2.setPosition(new Vector2f(this.body.getPosition().x-this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        this.eye2.setOutlineThickness(this.eye2.getRadius());
        this.mouth.setSize(new Vector2f(this.body.getSize().x/2, this.body.getSize().y/4 ));
        this.mouth.setOrigin(new Vector2f(this.mouth.getSize().x/2, this.mouth.getSize().y/2));
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getSize().y/5));
        set_teeth();


    }

    public void set_b_position(Vector2f pos){
        this.body.setPosition(pos);
        this.eye1.setPosition(new Vector2f(this.body.getPosition().x+this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        this.eye2.setPosition(new Vector2f(this.body.getPosition().x-this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getSize().y/5));
        set_teeth();
    }
    public void increment_b_position(){
        this.body.setPosition(this.body.getPosition().x+this.velocity_x, this.body.getPosition().y+this.velocity_y);
        this.eye1.setPosition(new Vector2f(this.body.getPosition().x+this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        this.eye2.setPosition(new Vector2f(this.body.getPosition().x-this.body.getSize().x/4, this.body.getPosition().y-this.body.getSize().y/4));
        this.mouth.setPosition(new Vector2f(this.body.getPosition().x, this.body.getPosition().y+this.body.getSize().y/5));
        set_teeth();
    }

    public Vector2f get_b_position(){ return this.body.getPosition();}

    public Vector2f get_b_size(){ return this.body.getSize();}

    public void food_found(ArrayList<food> f, ArrayList<Bacteria_one> almostB){        //rīkojamies , ja ēdiens ir atrasts
        increment_b_position();                         //refactor !!!!!!!!!!!!
        if(this.ifLookForFood == false){
            if(look_for_food(f) != null){               //parbaudam vai ir redzes loka
                float xD = look_for_food(f).getPos().x - this.body.getPosition().x;
                float yD = look_for_food(f).getPos().y - this.body.getPosition().y;
                float vec = (float)Math.sqrt(Math.pow(xD, 2)+Math.pow(yD, 2));
                float scalar = vec/velocity;
                this.velocity_x = xD/scalar;
                this.velocity_y = yD/scalar;
                this.ifLookForFood = true;
                
            }
            
        }
        else{       //kad iet pie ediena ieejam un parbaudam vai saskaras
            
            if(look_for_food(f) != null){     //vai ēdiens eksistē
                if(this.body.getGlobalBounds().intersection(look_for_food(f).getNuttedOnBitch().getGlobalBounds()) != null){
                    ability++;
                    this.ifLookForFood = false;
                    f.remove(look_for_food(f)); //aped edienu un ediens pazud
                }
            }
            else{   //ēdiens vairs nav tur, tatad nemekle 
                this.ifLookForFood = false;
            }
        }
        if(ability >= 6){
            almostB.add(new Bacteria_one(this.body.getPosition().x+10, this.body.getPosition().y+10));
            ability /= 2;
        }



    }

    public void hungry(boolean is){
        this.ifLookForFood = is;
    }


    public static void addCount(int n){
        count += n;
    }

    public food look_for_food( ArrayList<food> f){    //meklesim NUT
            float distanceFood = 0;                            //inicializējam , lai atrstu tuvāko ēdienu jeb ar mazāko distanci
            food smallestFood = null;                  //tam tuvkajam ēdienam indekss , ja indekss paliek -1, tad nav neko atradis!
            float smallestDistance = vision_r+50.f; 
            for (food nut : f) {
                distanceFood = (float)Math.sqrt(Math.pow(nut.getPos().x-this.body.getPosition().x, 2)+Math.pow(nut.getPos().y-this.body.getPosition().y, 2));
                if(distanceFood <= vision_r){            //parbaudam vai atrodas redzes lokā
                    if(distanceFood<smallestDistance){   //pārbaudam vai tas atrastais ir mazākais 
                        smallestDistance = distanceFood;
                        smallestFood = nut;
                    }
                }
            }
            return smallestFood;
            
    }


    public void decreaseAbility(){
        this.ability-= 0.01f;
    }

    public float getAbility(){
        return this.ability;
    }

    
    
    public void update_speed(){

        if(this.body.getPosition().x - this.body.getSize().x/2 <= super.A.x){ //parbaudam pa kreisi (A atrodas augsa pa kreisi)
            this.velocity_x *= -1;
            this.body.setPosition(new Vector2f(A.x+this.body.getSize().x/2, this.body.getPosition().y));
        };

        if(this.body.getPosition().y - this.body.getSize().y/2 <= super.A.y){ //parbaudam augsaa (A atrodas augsa pa kreisi)
            this.velocity_y *= -1;
            this.body.setPosition(new Vector2f(this.body.getPosition().x , A.y+ this.body.getSize().y/2));
        };

        if(this.body.getPosition().x + this.body.getSize().x/2 >= super.D.x){ //parbaudam pa labi (B atrodas pa labi augsa)
            this.velocity_x *= -1;
            this.body.setPosition(new Vector2f(D.x - this.body.getSize().x/2, this.body.getPosition().y));
        };

        if(this.body.getPosition().y + this.body.getSize().y/2 >= super.B.y){ //parbaudam leja ()
            this.velocity_y *= -1;
            this.body.setPosition(new Vector2f(this.body.getPosition().x , B.y - this.body.getSize().y/2));
        };

    }

    public static int getCount(){
        return count;
    }









}
