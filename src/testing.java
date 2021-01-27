public class testing {
    public static void main(String[] args) {
        ray a = new ray(new point(0, 0,0 ), new vector(1, 3, 0));
        ray b = new ray(new point(1, 3,0 ), new vector(2, 1, 0));
        System.out.println(mathFunctions.angleRay(a, b));

    }
}
