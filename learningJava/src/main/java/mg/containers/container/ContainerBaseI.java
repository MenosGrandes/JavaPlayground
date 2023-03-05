package mg.containers.container;

public interface ContainerBaseI<T> extends Iterable<T> {
    public boolean isEmpty();
    public int size();
    public  Object[] getElements();
}
