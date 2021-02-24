package app;

import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class Txt{

    String txt = new String();
    float posX;
    float posY;
    float scale;
    Text mytext;
    
    public Txt(String t, float Posx, float Posy)throws IOException{
        this.posX = Posx;
        this.posY = Posy;
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Home\\Desktop\\Arial.ttf");
        mytext = new Text();
        Font font = new Font();
        font.loadFromFile(path);
        mytext.setFont(font);
        mytext.setPosition(this.posX , this.posY);
    }

    public Txt(String t, float Posx, float Posy, float scale)throws IOException{
        this.posX = Posx;
        this.posY = Posy;
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Home\\Desktop\\Arial.ttf");
        this.scale = scale;
        mytext = new Text();
        this.txt=t;
        Font font = new Font();
        font.loadFromFile(path);
        mytext.setFont(font);
        mytext.setPosition(this.posX , this.posY);
    }
    public Txt(float Posx, float Posy, float scale)throws IOException{
        this.posX = Posx;
        this.posY = Posy;
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Home\\Desktop\\Arial.ttf");
        this.scale = scale;
        mytext = new Text();
        Font font = new Font();
        font.loadFromFile(path);
        mytext.setFont(font);
        mytext.setPosition(this.posX , this.posY);
    }


    public void update_string(String s){
        this.txt = s;
        this.mytext.setString(s);

    }

    public void render_Text(RenderWindow w){
            w.draw(mytext);
    }
}