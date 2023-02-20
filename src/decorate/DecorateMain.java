package decorate;

public class DecorateMain {

    public static void main(String[] args) {
        OrderComponent defaultOrderComponent = new DefaultOrderComponent();
        // 기본 기능 수행
        System.out.println("기본 기능 수행 시작======================");
        defaultOrderComponent.operation();
        System.out.println("기본 기능 수행 종료======================");

        System.out.println("b2cComponent 기능 수행 시작======================");
        OrderComponent b2cComponent = new B2cOrder(defaultOrderComponent);
        b2cComponent.operation();
        System.out.println("b2cComponent 기능 수행 종료======================");


        System.out.println("fnetComponent 기능 수행 시작======================");
        OrderComponent fnetComponent = new FnetOrder(defaultOrderComponent);
        fnetComponent.operation();
        System.out.println("fnetComponent 기능 수행 종료======================");


    }

}
