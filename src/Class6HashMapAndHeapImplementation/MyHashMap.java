package Class6HashMapAndHeapImplementation;

import java.util.*;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    // 负载因子 = HashMap 的“装满程度”阈值
    // 当 HashMap 的元素数量达到某个比例（超过 75%）时，就会触发：
    // 👉 扩容（rehashing）
    // 也就是创建一个更大的数组，把所有数据重新放进去。
    // ⭐ 为什么默认是 0.75？
    // 因为这是：
    // 空间利用率 与 查询效率 的最佳平衡点。字典类结构最常用的值（Java HashMap 也是 0.75）
    // 如果设置得太高：
    // 数组太满，hash 冲突增多，链表变长，性能下降（get/put 变慢）
    // 如果设置得太低：
    // 扩容太频繁， 浪费内存
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    // 扩容时数组容量扩大多少倍。
    private static final int SCALE_FACTOR = 2;
    // ⭐ 两者的关系（非常重要）
    // DEFAULT_LOAD_FACTOR 决定“什么时候扩容”
    // SCALE_FACTOR 决定“扩容到多大”
    // 举例：如果数组容量 = 16，loadFactor = 0.75
    // 那么最大安全数量：16 * 0.75 = 12
    // 当 size 超过 12：
    // 👉 自动扩容到 32（16 * 2），保持 HashMap 的查找性能

    private Node<K, V>[] array;
    private int size;
    private float loadFactor;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity Cannot Be <= 0");
        }
        this.array = (Node<K, V>[])(new Node[capacity]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public boolean containsKey(K key) {
        if (isEmpty()) {
            return false;
        }
        int index = getIndex(key);
        Node<K, V> curNode = array[index];
        while (curNode != null) {
            if (equalsKey(curNode.key, key)) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Node<K, V> node : array) {
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> curNode = array[index];
        while (curNode != null) {
            if (equalsKey(curNode.key, key)) {
                return curNode.value;
            }
            curNode = curNode.next;
        }
        return null;
    }

    // The return value is the original value corresponding to the key
    public V put(K key, V newValue) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> curNode = head;
        // Case 1: If the key already exists in the hash map
        while (curNode != null) {
            if (equalsKey(curNode.key, key)) {
                V result = curNode.value;
                curNode.value = newValue;
                return result;
            }
            curNode = curNode.next;
        }
        // Case 2: If the key does not exist in the hash map
        // Append the new node before the head and update the new head.
        Node<K, V> newNode = new Node<>(key, newValue);
        newNode.next = head;
        array[index] = newNode;
        size++;
        if (needsRehashing()) {
            rehashing();
        }
        return newValue;
    }

    // The return value is the original value corresponding to the key.
    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> curNode = array[index];
        Node<K, V> pre = null;
        while (curNode != null) {
            if (equalsKey(curNode.key, key)) {
                if (pre != null) {
                    pre.next = curNode.next;
                } else {
                    array[index] = curNode.next;
                }
                curNode.next = null;
                size--;
                return curNode.value;
            }
            pre = curNode;
            curNode = curNode.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0x7FFFFFFF; // guarantee non-negative
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2) {
        return Objects.equals(v1, v2);
    }

    private boolean equalsKey(K k1, K k2) {
        return Objects.equals(k1, k2);
    }

    private boolean needsRehashing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void rehashing() {
        Node<K, V>[] oldArray = array;
        array = (Node<K, V>[]) (new Node[array.length * SCALE_FACTOR]);
        for (Node<K, V> node : oldArray) {
            while (node != null) {
                Node<K, V> nextNode = node.next;
                int index = getIndex(node.key); // 需要重新计算index，因为array的长度发生了变化
                node.next = array[index];
                array[index] = node;
                node = nextNode;
            }
        }
    }
}

