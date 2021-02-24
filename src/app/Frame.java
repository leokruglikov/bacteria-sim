package app;

import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;


public class Frame {

protected Vector2f A;
protected Vector2f B;
protected Vector2f C;
protected Vector2f D;
private Vertex[] v = new Vertex[5];

public Frame (){
    A = new Vector2f(5, 5);
    B = new Vector2f(5, 695);
    C = new Vector2f(1895, 695);
    D = new Vector2f(1895, 5);
    this.v[0] = new Vertex(A);
    this.v[1] = new Vertex(B);
    this.v[2] = new Vertex(C);
    this.v[3] = new Vertex(D);
    this.v[4] = new Vertex(A);
}


public void render(RenderWindow w){
    w.draw(v, PrimitiveType.LINE_STRIP);
}


}