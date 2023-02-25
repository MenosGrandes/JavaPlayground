package mg.counter;

public class AdvanceInt extends Advancable<Integer> {

    @Override
    public Integer advance( Integer value ) {
        value++;
        return value;
    }
}
