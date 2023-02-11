package mg;

import mg.coordinates.LiftCoordinates;
import mg.coordinates.StargateDestination;
import mg.transportable.Lift;
import mg.transportable.Stargate;
import org.openjdk.jmh.annotations.Benchmark;

public class Main {
    public static void main( String[] args ) {
        /*
        Lift l = new Lift();
        l.setStartCoordinates( new LiftCoordinates(0) );
        l.setEndCoordinates( new LiftCoordinates(5) );
        l.move(  );



        l.setEndCoordinates( new LiftCoordinates(1) );
        l.move(  );

        l.setEndCoordinates( new LiftCoordinates(2) );
        l.move(  );

        */


        Stargate sg = new Stargate();
        sg.setEndCoordinates( new StargateDestination( new char[]{'a','v','c','d','1','d','4'} ));
        sg.move();

    }
}