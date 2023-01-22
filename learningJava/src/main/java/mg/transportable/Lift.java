package mg.transportable;

import mg.coordinates.Coordinates;
import mg.coordinates.LiftCoordinates;

public class Lift implements Transportable {
    private LiftCoordinates currentCoordinates;
    private LiftCoordinates endCoordinates;

    @Override
    public boolean move( ) {
        currentCoordinates.printCoordinates();
        return moveToDestination();
    }

    @Override
    public void setStartCoordinates( Coordinates c ) {
        currentCoordinates = (LiftCoordinates) c;
    }

    @Override
    public void setEndCoordinates( Coordinates c ) {
        endCoordinates = (LiftCoordinates) c;
    }

    private boolean moveToDestination()
    {
        int d = endCoordinates.getLevel();
        while(true)
        {
            currentCoordinates.printCoordinates();
            int c = currentCoordinates.getLevel();

            if ( c > d ) {
                currentCoordinates.previous();
            } else if ( c < d ) {
                currentCoordinates.next();
            } else // equal
            {
                System.out.println("ON DESTINATION LEVEL!");
                return true;
            }
        }


    }
}
