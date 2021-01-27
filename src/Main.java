import java.awt.*;

public class Main {
    public static void main(String[] args){
        scene a = scenes.scene1();
        render r = new render(a);
        long start = System.nanoTime();
        r.show();
        long end = System.nanoTime();
        System.out.println((end-start)/(double)1000000000 + " seconds with " + a.g.size() + " solids and " + 1 + " light sources");
    }
}
