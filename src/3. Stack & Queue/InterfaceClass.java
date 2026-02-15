import java.util.*;

public class InterfaceClass {
    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        ArrayDeque<Integer> q3 = new ArrayDeque<>();
        LinkedList<Integer> q4 = new LinkedList<>();

        q1.offer(1);
        //q1.offerFirst(1);
        q2.offerFirst(1);
    }
}
