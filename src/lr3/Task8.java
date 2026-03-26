package lr3;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyList list = new SinglyList();

        int[] values = {1, 2, 3, 4, 5};
        list.createHead(values);
        System.out.println("createHead: " + list.toString());

        list.createTail(values);
        System.out.println("createTail: " + list.toString());

        list.addFirst(100);
        list.addLast(200);
        System.out.println("После addFirst/addLast: " + list.toString());

        list.insert(2, 999);
        System.out.println("После insert(2, 999): " + list.toString());

        list.removeFirst();
        list.removeLast();
        System.out.println("После removeFirst/removeLast: " + list.toString());

        list.remove(2);
        System.out.println("После remove(2): " + list.toString());

        System.out.print("\nВведите размер массива для рекурсивного создания: ");
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("input[" + i + "] = ");
            input[i] = scanner.nextInt();
        }

        list.createHeadRec(input);
        System.out.println("createHeadRec: " + list.toStringRec());

        list.createTailRec(input);
        System.out.println("createTailRec: " + list.toStringRec());
    }

    private static class SinglyList {
        private Node head;

        public void createHead(int[] values) {
            head = null;
            for (int value : values) {
                head = new Node(value, head);
            }
        }

        public void createTail(int[] values) {
            head = null;
            Node tail = null;
            for (int value : values) {
                Node newNode = new Node(value, null);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
        }

        @Override
        public String toString() {
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

        public void addFirst(int value) {
            head = new Node(value, head);
        }

        public void addLast(int value) {
            Node newNode = new Node(value, null);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public void insert(int index, int value) {
            if (index <= 0 || head == null) {
                addFirst(value);
                return;
            }
            Node current = head;
            int i = 0;
            while (current.next != null && i < index - 1) {
                current = current.next;
                i++;
            }
            current.next = new Node(value, current.next);
        }

        public void removeFirst() {
            if (head != null) {
                head = head.next;
            }
        }

        public void removeLast() {
            if (head == null) {
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }

        public void remove(int index) {
            if (head == null) {
                return;
            }
            if (index <= 0) {
                removeFirst();
                return;
            }
            Node current = head;
            int i = 0;
            while (current.next != null && i < index - 1) {
                current = current.next;
                i++;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }

        public void createHeadRec(int[] values) {
            head = null;
            createHeadRecInternal(values, 0);
        }

        private void createHeadRecInternal(int[] values, int index) {
            if (index >= values.length) {
                return;
            }
            addFirst(values[index]);
            createHeadRecInternal(values, index + 1);
        }

        public void createTailRec(int[] values) {
            head = null;
            createTailRecInternal(values, 0);
        }

        private void createTailRecInternal(int[] values, int index) {
            if (index >= values.length) {
                return;
            }
            addLast(values[index]);
            createTailRecInternal(values, index + 1);
        }

        public String toStringRec() {
            return toStringRecInternal(head);
        }

        private String toStringRecInternal(Node node) {
            if (node == null) {
                return "";
            }
            if (node.next == null) {
                return String.valueOf(node.value);
            }
            return node.value + " -> " + toStringRecInternal(node.next);
        }
    }

    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
