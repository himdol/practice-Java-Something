package decorate;

/*
역할이 수행하는 작업
- Component : 기본 기능을 뜻하는 ConcreteComponent와 추가 기능을 뜻하는 Decorator의 공통 기능을 정의
  즉, 클라이언트는 Component를 통해 실제 객체를 사용함
- ConcreteComponent : 기본 기능을 구현하는 클래스
- Decorator : 많은 수가 존재하는 구체적인 Decorator의 공통 기능을 제공
- ConcreteDecoratorA, ConcreteDecoratorB : Decorator의 하위 클래스로 기본 기능에 추가되는 개별적인 기능을 뜻함
  ConcreteDecorator 클래스는 ConcreteComponent 객체에 대한 참조가 필요한데,
  이는 Decorator 클래스에서 Component 클래스로의 ‘합성(composition) 관계’를 통해 표현됨
 */
public abstract class OrderComponent {

    public abstract void operation();

}
