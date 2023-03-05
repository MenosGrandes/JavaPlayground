package mg.counter;

public class SimpleCounter {
    private int _count = 0;
    public int getCount(){return _count;}
    public void step(){_count++;}
    public void step(int value){_count+=value;}

}
