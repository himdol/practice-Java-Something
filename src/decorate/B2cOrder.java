package decorate;

public class B2cOrder extends OrderDecorate {

    public B2cOrder(OrderComponent orderComponent){
        super(orderComponent);
    }

    @Override
    public void operation() {
        super.operation();  // 기존 설정된 기능 수행
        // TODO 추가 기능 수행
        addOperation();
    }

    public void addOperation(){
        System.out.println("B2C Order operation 추가 기능 수행");
    }

}
