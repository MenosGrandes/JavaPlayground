package mg.counter.main;

import mg.counter.AdvanceInt;
import mg.counter.Counter;
import mg.counter.CounterOne;

public class Main {
    public static void main( String[] args ) {
        CounterOne<Integer> c = new CounterOne<Integer>(new AdvanceInt(),0 );
        System.out.println(c.getValue());


    }
    }
