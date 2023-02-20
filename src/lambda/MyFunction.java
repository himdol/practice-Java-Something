package lambda;

/**
 * 단 하나의 추상 메소드만 존재해야 함
 */
@FunctionalInterface
public interface MyFunction {
    public abstract int max(int a, int b);
}
