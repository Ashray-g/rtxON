import java.awt.*;

public class mathFunctions {
    public static Color[][] tfScene(scene a, int w, int h){
        point start = a.b;
        double lx = a.a.p.x;
        double ly = a.a.p.y;
        double lz = a.a.p.z;
        ray ra;
        Color[][] ren = new Color[h][w];
        int t = 0;
        for(int i = -h/2;i<h/2;i++){
            for(int j = -w/2;j<w/2;j++){
                t++;
                ra = new ray(start, new vector(35, (i/((double)h/2))*30, (j/((double)w/2))*40));
                Color cur = Color.black;
                double min = Integer.MAX_VALUE;
                double[] m = {0, 0, 0, 0};
                for(sphere g : a.g){
                    double[] q =  mathFunctions.intersectionRay(ra, g);
                    if(q[0] >= 0) {
                        if(q[0] < min){
                            min = q[0];
                            cur = g.color;
                            m = q;
                        }
                    }
                }
                if(m.length > 1){
                    ra = new ray(new point(m[1], m[2], m[3]), new vector(lx, ly, lz));

                    for(sphere g : a.g){
                        double q =  mathFunctions.intersectionRay(ra, g)[0];
                        if(q >= 0){
                            cur = cur.darker();
//                            cur = Color.black;
                            break;
                        }
                    }
                }
                ren[i + (h/2)][j + (w/2)] = cur;
            }
        }
        return ren;
    }
    public static double[] intersectionRay(ray ra, sphere s){
        vector rayVec = ra.vec;
        double xv = rayVec.x;
        double yv = rayVec.y;
        double zv = rayVec.z;
        point sphereCenter = s.p;
        double xc = sphereCenter.x;
        double yc = sphereCenter.y;
        double zc = sphereCenter.z;
        double r = s.radius;
        point rayOrigin = ra.p;
        double xp = rayOrigin.x;
        double yp = rayOrigin.y;
        double zp = rayOrigin.z;

        double a = xv*xv + yv*yv + zv*zv;
        double b = (xv*(xp-xc) + yv*(yp - yc) + zv*(zp-zc));
        double c = (xp-xc)*(xp-xc) + (yp-yc)*(yp-yc) + (zp-zc)*(zp-zc) - r*r;

        double discriminant = b*b - a*c;

        if(discriminant < 0){
            //not intersection of sphere
            return new double[]{-1.0};
        }else if(discriminant == 0){
            //tangent tp sphere
            return new double[]{-b/a};
        }else{
            //2 intersection to sphere
            double quad1 = (-b + Math.sqrt(discriminant))/a;
            double quad2 = (-b - Math.sqrt(discriminant))/a;
            double old = Math.sqrt(a);
            double len = Math.min(quad1, quad2) * old;
            double prop = len/old;
            double newX = xv * prop + ra.p.x+0.000001;
            double newY = yv * prop + ra.p.y+0.000001;
            double newZ = zv * prop + ra.p.z+0.000001;

            return new double[]{len, newX, newY, newZ};
        }
    }
}
