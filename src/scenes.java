import java.awt.*;

public class scenes {
    public static scene scene1(){
        Color p1c = new Color(210, 67, 83);
        Color p2c = new Color(6, 206, 139);
        Color p3c = new Color(216, 199, 218);
        Color p4c = new Color(76, 145, 209);
        Color p5c = new Color(245, 217, 146);
        Color p6c = new Color(176, 118, 208);
        sphere p = new sphere(new point(200, 0, -35), 50, p1c);
        sphere p2 = new sphere(new point(110, -40, -50), 30,  p2c);
        sphere p3 = new sphere(new point(250, 0, 30), 30,  p3c);
        sphere p4 = new sphere(new point(200, -50, 60), 30,  p4c);
        sphere p5 = new sphere(new point(180, -70, 10), 10,  p5c);
        sphere p6 = new sphere(new point(220, 70, 110), 80,  p6c);
        point s = new point(-80, 0, 0);
        scene a = new scene(s, 3840, 2880); //4k
        a.addLight(new light(new point(0, -30, -20)));
        a.addSphere(p);
        a.addSphere(p2);
        a.addSphere(p3);
        a.addSphere(p4);
        a.addSphere(p5);
        a.addSphere(p6);
        return a;
    }
    public static scene scene2(){
        Color p1c = new Color(210, 67, 83);
        sphere p = new sphere(new point(200, 0, -35), 50, p1c);
        point s = new point(-80, 0, 0);
        scene a = new scene(s, 3840, 2880); //4k
        a.addLight(new light(new point(0, -30, -20)));
        a.addSphere(p);
        return a;
    }
}
