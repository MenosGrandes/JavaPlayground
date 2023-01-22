package mg.transportable;


import mg.coordinates.Coordinates;

public interface Transportable {
    public boolean move( );
    public void setStartCoordinates( Coordinates c );
    public void setEndCoordinates( Coordinates c );

}
