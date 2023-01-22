package mg.transportable;

import mg.coordinates.Coordinates;
import mg.coordinates.StargateDestination;

public class Stargate implements Transportable {
    private StargateDestination endCoordinates = null;
    @Override
    public boolean move() {
        for(Character coordinate : endCoordinates)
        {
            System.out.println(coordinate);
        }
        return true;
    }

    @Override
    public void setStartCoordinates( Coordinates c ) {
        return;
    }

    @Override
    public void setEndCoordinates( Coordinates c ) {
        endCoordinates = (StargateDestination) c;
    }
}
