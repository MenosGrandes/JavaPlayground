package mg.sort;

import mg.containers.container.SortableContainerI;

import java.util.Arrays;

public class IsSorted {
    public static boolean isIt( SortableContainerI c )
    {
        Object a[] = Arrays.copyOf( c.getElements(), c.size() );
        Arrays.sort(a);
        return areContainersEquals(a, c.getElements());
    }
    private static boolean areContainersEquals(Object a[],Object b[])
    {
        if(a.length != b.length)
        {
            return false;
        }
        for(var i = 0 ; i < a.length; i ++)
        {
            if(a[i]!=b[i])
            {
                return false;
            }
        }
        return true;
    }
}
