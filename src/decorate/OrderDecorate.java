package decorate;

/**
 * 다양한 추가 기능에 대한 공통 클래스
 */
public class OrderDecorate extends OrderComponent {

    private OrderComponent orderComponent;

    // 합성(composition) 관계를 통해 OrderComponent 객체에 대한 참조
    public OrderDecorate(OrderComponent orderComponent){
        this.orderComponent = orderComponent;
    }

    @Override
    public void operation() {
        this.orderComponent.operation();
    }


}
