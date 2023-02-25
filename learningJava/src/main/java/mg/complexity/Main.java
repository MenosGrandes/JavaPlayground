package mg.complexity;

import org.apache.commons.math3.util.Pair;

import java.util.List;

public class Main {

    public static Pair<Integer, Integer> minMan_1( List<Integer> container)
    {
        int min = container.get(0);
        int max = container.get(0);
        for(var i : container) {
            if ( i < min ) {
                min = i;
            } else if ( i > max ) {
                max = i;
            }
        }
        return new Pair<Integer, Integer>(min,max);
    };
    public static Pair<Integer, Integer> minMan_2( List<Integer> container)
    {
        int min = container.get(0);
        for(var i : container) {
            if ( i < min ) {
                min = i;
            }
        }
        int max = container.get(0);
        for(var i : container) {
            if ( i > max ) {
                max = i;
            }
        }
        return new Pair<Integer, Integer>(min,max);
    };
    public static void main( String[] args ) {

        var mm = minMan_1( List.of(2, 3, 11, -32, 11, 0) );
        System.out.println( mm.getFirst() + " " + mm.getSecond() );

        var mm2 = minMan_2( List.of(2, 3, 11, -32, 11, 0) );
        System.out.println( mm2.getFirst() + " " + mm2.getSecond() );
    }
    };