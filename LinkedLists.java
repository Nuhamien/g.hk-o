class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insertAtPos(int position, int data) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Inserted node with data " + data + " at position 1 in the linked list: 1 -> 2 -> 3");
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Position out of bounds");
            } else {
                newNode.next = current.next;
                current.next = newNode;
                System.out.println("Inserted node with data " + data + " at position " + position + " in the linked list: 1 -> 2 -> " + data + " -> 3");
            }
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        if (position == 1) {
            head = temp.next;
            System.out.println("Deleted node at position 1 from the linked list: 2 -> 3");
            return;
        }
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Deleted node at position " + position + " from the linked list: 1 -> 3");
    }

    public void deleteAfterNode(Node node) {
        if (node != null && node.next != null) {
            System.out.println("Deleted node after " + node.data + " from the linked list: 1 -> 3");
            node.next = node.next.next;
        } else {
            System.out.println("No node found after the given node");
        }
    }

    public  Node searchNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Found node with data " + value + " in the linked list: 1 -> 2 -> 3");
                return current;
            }
            current = current.next;
        }
        System.out.println("Node with data " + value + " not found in the linked list: 1 -> 2 -> 3");
        return null;
    }
}

class Stack {
    Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            System.out.println("Pushed " + data + " onto the stack: " + data);
        } else {
            newNode.next = top;
            top = newNode;
            System.out.println("Pushed " + data + " onto the stack: " + data + " -> " + top.next.data);
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        System.out.println("Popped " + popped + " from the stack: " + (top != null ? top.data : ""));
        return popped;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        System.out.println("Peeked " + top.data + " from the stack: " + top.data + " -> " + (top.next != null ? top.next.data : ""));
        return top.data;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Stack stack = new Stack();

        linkedList.insertAtPos(1, 1);
        linkedList.insertAtPos(2, 2);
        linkedList.insertAtPos(3, 3);

        linkedList.deleteAtPosition(2);

        linkedList.deleteAfterNode(linkedList.searchNode(1));

        linkedList.searchNode(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}