package LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) throws Exception {
        LinkedList ll = new LinkedList();
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addAt(0, 5);
        ll.addAt(4, 40);
        ll.addAt(3, 50);
        ll.display();

        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
    }
}

class LinkedList {
    private class Node {
        int data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    private Node getNodeAt(int index) throws Exception {
        if (this.head == null) {
            throw new Exception("List is Empty");
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            if (temp == null)
                break;
            temp = temp.next;
        }

        if (temp != null) {
            return temp;
        } else {
            throw new Exception("Index out of bounds");
        }
    }

    public int getFirst() throws Exception {
        if (this.head == null) {
            throw new Exception("List is Empty");
        }

        return this.head.data;
    }

    public int getLast() throws Exception {
        if (this.head == null) {
            throw new Exception("List is Empty");
        }

        return this.tail.data;
    }

    private int getAt(int index) throws Exception {
        if (this.head == null) {
            throw new Exception("List is Empty");
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            if (temp == null)
                break;
            temp = temp.next;
        }

        if (temp != null) {
            return temp.data;
        } else {
            throw new Exception("Index out of bounds");
        }
    }

    public void addFirst(int data) {
        Node nn = new Node();
        nn.data = data;

        if (this.size == 0) {
            nn.next = null;
            this.head = nn;
            this.tail = nn;
        } else {
            nn.next = this.head;
            this.head = nn;
        }

        this.size++;
    }

    public void addLast(int data) {
        Node nn = new Node();
        nn.data = data;
        nn.next = null;

        if (this.size == 0) {
            this.head = nn;
            this.tail = nn;
        } else {
            this.tail.next = nn;
            this.tail = nn;
        }

        this.size++;
    }

    public void addAt(int index, int data) throws Exception {
        if (index < 0 || index > this.size) {
            throw new Exception("Index out of bound");
        }

        if (index == 0) {
            this.addFirst(data);
        } else if (index == this.size) {
            this.addLast(data);
        } else {
            Node nm1 = getNodeAt(index - 1);
            Node np1 = nm1.next;

            Node nn = new Node();
            nn.data = data;
            nm1.next = nn;
            nn.next = np1;
            this.size++;
        }
    }

    public int removeFirst() throws Exception {
        if (this.head == null) {
            throw new Exception("List is already empty");
        }

        Node rv = this.head;
        this.head = this.head.next;
        this.size--;
        return rv.data;
    }

    public int removeLast() throws Exception {
        if (this.head == null) {
            throw new Exception("List is already empty");
        }

        int rv = this.tail.data;
        Node temp = this.head;
        Node prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        if (prev == null) {
            this.head = this.tail = null;
        } else {
            prev.next = null;
            this.tail = prev;
        }
        this.size--;

        return rv;
    }

    public int removeAt(int index) throws Exception {
        if (index < 0 || index >= this.size) {
            throw new Exception("Index out of bounds!");
        }

        if (index == 0) {
            return this.removeFirst();
        } else if (index == this.size - 1) {
            return this.removeLast();
        } else {
            Node nm1 = getNodeAt(index - 1);
            Node n = nm1.next;
            Node np1 = n.next;

            nm1.next = np1;
            this.size--;

            return n.data;
        }

    }

    public void display() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
