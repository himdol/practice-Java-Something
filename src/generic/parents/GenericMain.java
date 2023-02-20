package generic.parents;



import generic.sample.Box;
import generic.sample.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * 컴파일 시 타입 체크 및 결정
 *
 * 상환 경계 : <? extends T>
 *     - 와일드카드(?)의 상한 제한, T 와 그 자손들만 가능
 * 하한 경계 : <? super T>
 *     - 와일드카드(?)의 하한 제한 T 와 그 조상들만 가능
 * 제한 없음 : <?>
 *     - 제한 없음
 */
public class GenericMain {

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Fruit banana = new Fruit("바나나");
        fruitBox.setItem(banana);

        List<Bumo> bumos = new ArrayList<>();
        testExtends(bumos);
        testSuper(bumos);
    }


    public static <T> void testExtends(List<? extends Number> list){
        System.out.println("상한 경계");
    }

    public static <T> void testSuper(List<? super Sonja> list){
        System.out.println("하한 경계");
    }

}
