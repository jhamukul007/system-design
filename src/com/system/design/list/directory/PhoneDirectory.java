package com.system.design.list.directory;

import com.system.design.list.queue.Queue;
import com.system.design.list.queue.QueueUsingLinkedList;

import java.util.HashSet;
import java.util.Set;

public class PhoneDirectory {
    private Queue<Integer> directory;
    private Set<Integer> availableNumbers;

    /*
      Time: O(maxNumbers) ~ O(n) where n is number of phone number.
     */
    public PhoneDirectory(int maxNumbers) {
        this.directory = new QueueUsingLinkedList<>();
        this.availableNumbers = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            directory.offer(i);
            availableNumbers.add(i);
        }
    }

    /*
        Time: O(1)
     */
    public Integer get() {
        if (directory.size() == 0) {
            return null;
        }
        Integer number = directory.poll();
        availableNumbers.remove(number);
        return number;
    }

    /**
     * Time: O(1) in the worst case it would be O(log(n))
     *
     * @param number
     * @return
     */

    public boolean check(Integer number) {
        return availableNumbers.contains(number);
    }


    /**
     * Time: O(1)
     *
     * @param number
     */
    public void release(Integer number) {
        if (!availableNumbers.contains(number)) {
            directory.offer(number);
            availableNumbers.add(number);
        }
    }
}
