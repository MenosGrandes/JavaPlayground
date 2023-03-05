package mg.counter;


import mg.counter.advance.Advancable;

public abstract class Counter<T> implements CounterI<T>
{
    protected  T value;
    protected Advancable<T> advance;
    public Counter(Advancable<T> _a, T startValue)
    {
        advance = _a;
        value=startValue;
    };

}
