package lambda;

/**
 * 람다식을 참조 변수로 다룰 수 있음
 *
 */
public class LambdaMain3 {

    public static void main(String[] args) {

        method(() -> System.out.println("test"));

    }

    public static void method(PrintFunction p){
        p.print();
    }
}
