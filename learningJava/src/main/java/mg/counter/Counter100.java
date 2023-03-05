package mg.counter;

import mg.counter.advance.Advancable;

public class Counter100<Integer> extends Counter<Integer>{


    public Counter100( Advancable<java.lang.Integer> _a, java.lang.Integer startValue ) {
        super( (Advancable<Integer>) _a, (Integer) startValue );
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void step() {
        value = advance.advanceBy( value);
    }

}
