import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class render {
        int w = 800;
        int h = 600;
        scene a;
        BufferedImage display;
    public render(scene a){
        this.a = a;
        w = a.w;
        h = a.h;
        display = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    }

    public void traceRays(){
        Color[][] g = mathFunctions.tfScene(a, w, h);
        for(int i = 0;i<g.length;i++){
            for(int j = 0;j<g[0].length;j++){
                display.setRGB(j, i, g[i][j].getRGB());
            }
        }
    }

    public void show() {
        traceRays();
//        JFrame frame = buildFrame();
//        JPanel pane = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.drawImage(display, 0, 0, null);
//            }
//        };
//        frame.add(pane);
//        frame.setVisible(true);
        try {
            // retrieve image
            File outputfile = new File("render.png");
            ImageIO.write(display, "png", outputfile);
        } catch (IOException e) {

        }
    }

    private JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(w+40, h+30);
        frame.setVisible(true);
        return frame;
    }

}
