package mg.counter;

import mg.counter.advance.Advancable;

public class CounterOne<T> extends Counter<T>{


    public CounterOne( Advancable<T> _a, T startValue ) {
        super( _a, startValue );
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void step() {
        value = advance.advance( value );
    }

}
