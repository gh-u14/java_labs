package lr3;

public class Task7 {
    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40, 50};

        Node headBuilt = createFromHead(values);
        Node tailBuilt = createFromTail(values);

        System.out.println("Список, созданный с головы: " + toString(headBuilt));
        System.out.println("Список, созданный с хвоста: " + toString(tailBuilt));
    }

    private static Node createFromHead(int[] values) {
        // Наращивание списка с головы
        Node head = null; // начальное значение ссылки на голову
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
        return head;
    }

    private static Node createFromTail(int[] values) {
        // Создание несвязанных узлов и последующее связывание через next
        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i], null);
        }
        for (int i = 0; i + 1 < values.length; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes.length == 0 ? null : nodes[0];
    }

    private static String toString(Node head) {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }


    private static class Node {
        public int value; // значение
        public Node next; // ссылка (указатель) на следующий узел

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
