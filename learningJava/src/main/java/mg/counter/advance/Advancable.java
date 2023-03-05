package mg.counter.advance;

public  abstract class Advancable<T> {
    public abstract T advance( T value );
    public abstract T advanceBy( T value );
    public abstract  void setBy(T value);

}
