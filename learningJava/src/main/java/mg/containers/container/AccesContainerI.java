package mg.containers.container;

import java.util.Iterator;

public interface AccesContainerI<T> extends ContainerBaseI<T>{

    T get( int position);

}
