package function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionMain {

    public static void main(String[] args) {
        // function 패키지
//        Runnable r = () -> {};
//        new Thread(r).start();
//        Supplier;
//        Consumer;
//        Function;
//        Predicate;

        Predicate<String> isEmptyStr = s -> s.length() == 0;
        String a = "";
        String b = "not empty";
        System.out.println("a is empty : " + isEmptyStr.test(a));
        System.out.println("b is empty : " + isEmptyStr.test(b));

    }

}
