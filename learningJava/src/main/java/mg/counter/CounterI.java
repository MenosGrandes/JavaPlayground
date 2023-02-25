package mg.counter;

public interface CounterI<T> {
    T getValue();
    void step();
}
