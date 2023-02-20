package function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupConMain {

    public static void main(String[] args) {
        // 공급자
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        // 소비자
        Consumer<Integer> c = (i) -> System.out.print(i + ", ");
        // true / false 판별
        Predicate<Integer> p = i -> i % 2 == 0;
        // 매개변수 타입, 리턴 타입 -> 연산
        Function<Integer, Integer> f = i -> i / 10 * 10;    // i 의 일의 자리를 삭제

        List<Integer> list = new ArrayList<>();
        makeRandom(s, list);

        System.out.println("makeRandom : " + list);

        printEventNumber(p, c, list);

        List<Integer> newList = doSomething(f, list);

        System.out.println("printEventNumber : " + newList);

    }

    private static List<Integer> doSomething(Function<Integer, Integer> f, List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list.size());

        for(Integer i : list){
            newList.add(f.apply(i));
        }

        return newList;
    }

    private static void printEventNumber(Predicate<Integer> p, Consumer<Integer> c, List<Integer> list) {
        System.out.print("[");

        for(Integer i : list){
            if(p.test(i)){
                c.accept(i);
            }
        }

        System.out.println("]");
    }

    private static void makeRandom(Supplier<Integer> s, List<Integer> list) {
        for(int i=0; i<10; i++){
            list.add(s.get());
        }
    }

}
