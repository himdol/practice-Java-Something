package lambda2;

import java.util.Collections;
import java.util.List;

public class LambdaMain {

  public static void main(String[] args) {

  }

  public static void sort2(List<String> words) {
    Collections.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
    System.out.println("sort2 : " + words);
  }


}
