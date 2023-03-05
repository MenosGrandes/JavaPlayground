package mg.counter.main;

import mg.counter.SimpleCounter;

public class Main {
    public static void main( String[] args ) {
        /*
        CounterOne<Integer> c = new CounterOne<Integer>(new AdvanceInt(),0 );
        System.out.println(c.getValue());
c.step();
*/

        SimpleCounter sc = new SimpleCounter();
        sc.step();
        sc.step();
        sc.step();

        System.out.println(sc.getCount());
        sc.step();
        sc.step();
        System.out.println(sc.getCount());
        sc.step(10);
        System.out.println(sc.getCount());
    }
    }
