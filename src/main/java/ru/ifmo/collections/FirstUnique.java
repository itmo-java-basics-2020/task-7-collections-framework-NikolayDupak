package ru.ifmo.collections;

import java.nio.charset.IllegalCharsetNameException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */

public class FirstUnique {
    HashSet<Integer> hashSet = new HashSet();

    LinkedList<Integer> listQueue = new LinkedList();

    public FirstUnique(int[] numbers) {

        for (int elem = 0; elem < numbers.length; elem++) {
            this.add(numbers[elem]);
        }
    }

    public int showFirstUnique() {
        if(listQueue.isEmpty()){
            return -1;
        }

        return listQueue.getFirst();
    }

    public void add(int value) {
        if (!hashSet.contains(value)) {
            hashSet.add(value);
            listQueue.add(value);

        }
        else {
            Iterator<Integer> iterator = listQueue.iterator();
            while(iterator.hasNext())
            {
                Integer val = iterator.next();
                if (val.equals(value))
                {
                    iterator.remove();
                    break;
                }
            }
        }
    }
}
