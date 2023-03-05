package mg.counter.advance;

import mg.counter.advance.Advancable;

public class AdvanceInt extends Advancable<Integer> {
    private Integer by = 0;
    @Override
    public Integer advance( Integer value ) {
        value++;
        return value;
    }

    @Override
    public Integer advanceBy( Integer value) {
    value+=by;
    return value;
    }

    @Override
    public void setBy( Integer value ) {
    by = value;
    }
}
