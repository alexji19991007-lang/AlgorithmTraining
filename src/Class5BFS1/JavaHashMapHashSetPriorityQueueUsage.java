package Class5BFS1;

import java.util.*;

public class JavaHashMapHashSetPriorityQueueUsage {
    public static void main(String[] args) {
        UseHashMap();
        System.out.println();
        UseHashSet();
        System.out.println();
        UsePriorityQueue();
    }

    public static void UseHashMap() {
        System.out.println("HashMap output:");

        HashMap<String, Integer> students = new HashMap<>();
        students.put("Alice", 85);
        students.put("Bob", 90);
        students.put("Charlie", 78);

        System.out.println(students.get("Bob")); // 90
        
        students.remove("Charlie");

        System.out.println(students.containsKey("Alice")); // true
        System.out.println(students.getOrDefault("Dylan", 75)); // 75

        // for-each loop
        int[] myArray = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
        for (int x : myArray) {
            System.out.println(x);
        }
        for (HashMap.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void UseHashSet() {
        System.out.println("HashSet output:");

        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // Duplicate, ignored
        System.out.println(fruits); // No duplicate values
        System.out.println(fruits.contains("Banana")); // true
    }

    public static void UsePriorityQueue() {
        System.out.println("PriorityQueue output:");

        // Creating a Min Priority Queue，i.e. min heap --> 越小的数字越早出来
        Queue<Integer> minHeap = new PriorityQueue<>();

        // Inserting elements
        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(50);
        minHeap.offer(20);

        System.out.println("Priority Queue (MinHeap): " + minHeap);

        // Peek (view smallest element)
        System.out.println("Peek MinHeap: " + minHeap.peek());

        // Removing elements
        while (!minHeap.isEmpty()) {
            System.out.println("Removed MinHeap: " + minHeap.poll());
            System.out.println("Priority Queue (MinHeap): " + minHeap);
        }

        // Max Priority Queue, i.e. max heap --> 越大的数字越早出来
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            // return 0代表t1和t2一样优先，可能t1先出来也有可能t2先出来
            // primitive types用==来比较
            // non-primitive types用equals来比较
            if (a.equals(b)) { // 因为t1和t2都是Integer Type，不是primitive type，所以用equals来比较
                return 0;
            }
            // return小于0的数字代表t1更优先，大于0的数字代表t2更优先。
            return a > b ? -1 : 1; 
        }); // we are writing a comparator here

        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(50);
        maxHeap.offer(20);

        System.out.println("Priority Queue (MaxHeap): " + maxHeap);

        // Peek (view largest element)
        System.out.println("Peek MaxHeap: " + maxHeap.peek());

        // Removing elements
        while (!maxHeap.isEmpty()) {
            System.out.println("Removed MaxHeap: " + maxHeap.poll());
        }
    }

    public static void HeapifyArrayOrList() {
        // 一定要是一个array of non-primitive type
        Integer[] arr = {40, 10, 30, 50, 20};
        // 这个不行：
        // int[] arr = {40, 10, 30, 50, 20};

        // Convert array to list and heapify
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>(Arrays.asList(arr));

        System.out.println("Heap elements (removal order):");

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}
