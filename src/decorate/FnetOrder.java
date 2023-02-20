package decorate;

public class FnetOrder extends OrderDecorate {

    public FnetOrder(OrderComponent orderComponent){
        super(orderComponent);
    }

    @Override
    public void operation() {
        super.operation();  // 기존 설정된 기능 수행
        // TODO 추가 기능 수행
        addOperation();
    }

    public void addOperation(){
        System.out.println("Fnet Order operation 추가 기능 수행");
    }

}
