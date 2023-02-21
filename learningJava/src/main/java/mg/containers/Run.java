package mg.containers;

import mg.containers.bag.Bag;
import mg.containers.bag.BagArray;
import mg.containers.bag.BagNode;

public class Run {
    public static void main( String[] args ) {

        BagArray<Integer> a = new BagArray<>();
        a.add(1);
        a.add(13);
        for(var c : a)
        {
            System.out.println(c);
        }

        BagNode<Integer> bg= new BagNode<>();
        bg.add(2);
        bg.add(14);

        for(var c : bg)
        {
            System.out.println(c);
        }
        System.out.println(a.isEmpty());
    }

}
