package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 람다식(lambda expression)
 * 함수형 프로그램 가능해짐
 * 메소드 매개변수에 식(expression) 을 전달할 수 있다
 * 람다는 익명 클래스와 동등하다
 *
 * 접근제어자 리턴값 메소드명 (매개변수) -> (매개변수)로 표현하는게 람다식
 * 타입추론 때문에 생략 가능
 * 단 하나의 추상 메소드만 존재해야 함
 * @FunctionalInterface 명시적 선언
 *
 * 매개 변수 하나일 경우 괄호 생략 가능
 * 두 개 이상일 경우 괄호
 * 람다식을 참조 변수로 다룰 수 있다
 *
 * 차이점 :
 * - 객체 생성 -> 메소드 호출
 * - 람다식 자체가 메소드 역할 가능
 * - 문장(statement) 가 아닌 식(expression) 이므로 끝에 ;를 붙이지 않는다
 * ex) 문장 : return a > b ? a : b;
 * ex) 식 : (int a, int b) -> a > b ? a : b
 *
 * Object 타입으로 형변환 안됨, 함수형 인터페이스로만 형변환 가능
 * Object obj = (Object)( () -> {} )
 *
 * java01.lambda.LambdaMain2$1 : 외부 클래스 이름&&Lambda$번호
 *
 *
 */
public class LambdaMain {

    public static void main(String[] args) {
        // 타입 변수명 = 객체 생성
        List<String> words = new ArrayList<>();
        words.add("333");
        words.add("1");
        words.add("22");
        words.add("55555");
        words.add("4444");

        System.out.println(words);
        sort1(words);

        Collections.shuffle(words);
        System.out.println("셔플 : " + words);

        sort2(words);

        Collections.shuffle(words);
        System.out.println("셔플 : " + words);

        sort3(words);

        Collections.shuffle(words);
        System.out.println("셔플 : " + words);

        sort4(words);


    }

    public static void sort1(List<String> words){
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println("sort1 : " + words);
    }
    public static void sort2(List<String> words){
        Collections.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println("sort2 : " + words);
    }

    public static void sort3(List<String> words){
        Collections.sort(words, String::compareTo);
        System.out.println("sort3 : " + words);
    }

    public static void sort4(List<String> words){
        words.sort(Comparator.comparingInt(String::length));
        System.out.println("sort4 : " + words);
    }


}
