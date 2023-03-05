package mg.counter.factory;

import mg.counter.advance.AdvanceInt;
import mg.counter.CounterOne;
import mg.counter.advance.AdvanceLong;

public class Counters {
    public static CounterOne<Integer> intStartFrom0()
    {
        return new CounterOne<Integer>(new AdvanceInt(), 0 );
    }
    public static CounterOne<Long> longStartFrom0()
    {
        return new CounterOne<Long>(new AdvanceLong(), 0l );
    }
}
