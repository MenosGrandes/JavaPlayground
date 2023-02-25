package mg.containers.container;

public interface SetableContainerI<T>  extends ContainerBaseI<T> {
    void set(int position, T value);

}
