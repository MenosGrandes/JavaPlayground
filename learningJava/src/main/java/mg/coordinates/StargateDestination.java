package mg.coordinates;

import java.util.Iterator;

public class StargateDestination extends Coordinates implements Iterable<Character>{

    public  StargateDestination( final char []_chavron)
    {
       this.chavron  = _chavron;
    }
    private final char []chavron;
    @Override
    public void printCoordinates() {
        for(char c : this.chavron)
        {
            System.out.println(c);
        }

    }

    class StargateIterator implements Iterator<Character>
    {
        private int current_chavron_number = 0;
        private final char []chavron ;

        StargateIterator( char [] _chavron)
        {
            this.chavron = _chavron;
        }
        @Override
        public boolean hasNext() {
            return (current_chavron_number < chavron.length);
        }

        @Override
        public Character next() {
            Character to_return =  chavron[current_chavron_number];
            current_chavron_number++;
            return to_return;
        }
    }



    @Override
    public Iterator<Character> iterator() {
        return new StargateIterator(chavron);
    }
}
