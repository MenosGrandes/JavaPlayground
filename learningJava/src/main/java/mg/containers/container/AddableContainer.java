package mg.containers.container;

public interface AddableContainer<T> extends ContainerBaseI<T> {
    void add (T value);
}
