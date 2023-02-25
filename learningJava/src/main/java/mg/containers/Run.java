package mg.containers;

import mg.containers.bag.Bag;
import mg.containers.bag.BagArray;
import mg.containers.bag.BagNode;

public class Run {
    public static void main( String[] args ) {

        Bag<Integer> a = new BagArray<>();
        for(var i = 0; i < 10000;i++)
        {
            a.add(i);
        }
        for(var c : a)
        {
            System.out.print(c + " ");
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
