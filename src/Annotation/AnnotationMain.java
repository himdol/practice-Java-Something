package Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

public class AnnotationMain {

  public static void main(String[] args) {
    /*
    @Override : 시그니처 메소드,
    @Overrode : 재정의,
    @Deprate :
    @Document : Java Doc,
    @Target : 타입정의
    @

     */
    test();
  }

  @ElapsedTime
  public static void test() {
    System.out.println("실행");
  }

}
