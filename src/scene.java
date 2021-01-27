import java.util.ArrayList;

public class scene {
    ArrayList<sphere> g = new ArrayList<>();
    point b;
    light a;
    int w, h;
    public scene(point b, int w, int h){
        this.b = b;
        this.h = h;
        this.w = w;
    }
    public void addLight(light a){
        this.a = a;
    }
    public void addSphere(sphere t){
        g.add(t);
    }
}
