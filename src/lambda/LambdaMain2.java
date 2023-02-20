package lambda;

public class LambdaMain2 {

    public static void main(String[] args) {
        MyFunction f = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return (a > b) ? a : b;
            }
        };

        LambdaMain2 main = new LambdaMain2();
        System.out.println(main.getClass().getName());
        System.out.println(f.getClass().getName());



        System.out.println(f.max(1,5));

        // public abstract int max(int a, int b);
        MyFunction f3 = (int a, int b) -> (a > b) ? a : b;
        MyFunction f2 = (int a, int b) -> {
            System.out.println("a : " + a + " b : " + b);
            return (a > b) ? a : b;
        };

        System.out.println(f2.max(5,1));
    }

}
