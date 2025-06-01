🧩 Problem Statement: Implement a Generic Round Robin Data Structure

Design and implement a generic Round Robin data structure that allows elements to be added and then retrieved in a circular fashion, one at a time, in insertion order.

This structure simulates a round robin scheduler, which loops through the inserted elements indefinitely, returning them one by one in order, and starting again once the end is reached.

<b> Requirements: </b><br>
Implement a class RoundRobinAlgorithm<T> with the following functionality:

🔹 void insert(T data)
* Adds a new element to the structure.
* Elements must be returned in the order they were inserted.
* Internally maintain a circular list of elements.

🔹 T get()
* Returns the next element in the round robin cycle.

* Advances the internal pointer to the next item.



