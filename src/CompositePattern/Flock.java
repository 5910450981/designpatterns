package CompositePattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Flock implements Quackable {

    ArrayList quackers = new ArrayList();

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        boolean first = true;
        Iterator iterator = quackers.iterator();

        while (iterator.hasNext()){
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
            if (first){
                System.out.print("leader : ");
                quacker.quack();
                System.out.print("leader : ");
                quacker.quack();
                first = false;
            }
        }
    }
}
