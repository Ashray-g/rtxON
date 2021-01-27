public class vector {
    double x, y, z;
    double len;
    public vector(double x,double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        len = Math.sqrt(x*x + y*y + z*z);
    }
}
