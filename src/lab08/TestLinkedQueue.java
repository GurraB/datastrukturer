package lab08;

public class TestLinkedQueue {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println("size=" + queue.size());
        System.out.println("Först placerad i kön:");
        System.out.println(queue.peek());
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
