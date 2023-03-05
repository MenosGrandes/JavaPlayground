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
    public static boolean find(List<Integer> container, Integer n)
    {
        for(var i : container)
        {
            if(i == n )
            {
                return true;
            }
        }
        return false;
    }
    public static Integer add(List<Integer> container)
    {
        var sum = 0;
        for(var i : container)
        {
            sum += i;
        }
        return sum;
    }
    public static int factorial(int n)
    {
        if( n < 0)
        {return -1;}
        else if( n == 0)
        {
            return 1;
        }
        else
        {
            return n* factorial( n-1 );
        }

    }

    public static boolean isPrime(int n)
    {
        for(int i =0 ; i < Math.sqrt( n );i++) {

            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static Integer add_if(List<Integer> container)
    {
        var sum = 0;
        for(var i : container)
        {
            if(i > 0) {
                sum += i;
            }
        }
        return sum;
    }
    public static Integer add(List<Integer> a, List<Integer> b)
    {
        var sum = 0;
        for(var a_i : a)
        {
            for(var b_i : b) {
                sum += a_i + b_i;
            }
        }
        return sum;
    }
    public static Integer add_10k(List<Integer> a)
    {
        var sum = 0;
        for(var a_i : a)
        {
            for(var i = 0 ; i < 10000;i++) {
                sum += a_i + i;
            }
        }
        return sum;
    }
    public static Integer add_doubled(List<Integer> a)
    {
        var sum = 0;
        for(var a_i : a)
        {
            for(var a_i2 : a)
             {
                sum += a_i2 + a_i;
            }
        }
        return sum;
    }
    public static Integer add_2(List<Integer> a, List<Integer> b)
    {
        var sum = 0;
        for(var a_i : a)
        {
            sum += a_i;
        }
        for(var b_i : b) {
            sum +=  b_i;
        }
        return sum;
    }
    public static void main( String[] args ) {

        var mm = minMan_1( List.of(2, 3, 11, -32, 11, 0) );
        System.out.println( mm.getFirst() + " " + mm.getSecond() );

        var mm2 = minMan_2( List.of(2, 3, 11, -32, 11, 0) );
        System.out.println( mm2.getFirst() + " " + mm2.getSecond() );

        var sum = add( List.of(2, 3, 11, -32, 11, 0) );
        System.out.println( sum);
        var sum2 = add( List.of(2, 3, 11, -32, 11, 0), List.of(2, 3, 11, -32, 11, 0) );
        System.out.println( sum2);
    }
    };