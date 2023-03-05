package mg.counter.advance;

public class AdvanceLong extends Advancable<Long> {
    private Long by = 0l;
    @Override
    public Long advance( Long value ) {
        value++;
        return value;
    }

    @Override
    public Long advanceBy( Long value) {
    value+=by;
    return value;
    }

    @Override
    public void setBy( Long value ) {
    by = value;
    }
}
