package decorate;

/**
 * 기본 클래스
 */
public class DefaultOrderComponent extends OrderComponent {

    @Override
    public void operation() {
        System.out.println("order component 기본 연산");
    }

}
