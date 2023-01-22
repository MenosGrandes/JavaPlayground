package mg.coordinates;

public class LiftCoordinates extends Coordinates {
    public static final int []levels = {0,1,2,3,4,5,6,7,8,9,10};
    private int level = 0;
    public LiftCoordinates( int level )
    {
        this.level = level;
    }
    @Override
    public void printCoordinates() {
        System.out.println( level );
    }
    public int getLevel()
    {
        return level;
    }

    public void next()
    {
        level++;
    }
    public void previous()
    {
        level--;
    }

}
