class Node {
    Node prev, next;
    int val;

    public Node(int val) {
        this.val = val;
    }
}

class MyCircularDeque {

    private Node head, tail;
    private int currentSize, maxSize;

    public MyCircularDeque(int k) {
        System.gc();
        currentSize = 0;
        maxSize = k;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int val) {
        if (isFull() == true) {
            return false;
        } else {
            Node newNode = new Node(val);
            newNode.next = head.next;
            newNode.prev = head;
            head.next.prev = newNode;
            head.next = newNode;
            currentSize += 1;
            return true;
        }
    }

    public boolean insertLast(int val) {
        if (isFull() == true) {
            return false;
        } else {
            Node newNode = new Node(val);
            newNode.prev = tail.prev;
            newNode.next = tail.prev.next;
            tail.prev.next = newNode;
            tail.prev = newNode;
            currentSize += 1;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty() == true)
            return false;
        else {
            head.next = head.next.next;
            head.next.prev.prev = null;
            head.next.prev.next = null;
            head.next.prev = head;
            currentSize -= 1;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty() == true)
            return false;
        else {
            tail.prev = tail.prev.prev;
            tail.prev.next.next = null;
            tail.prev.next.prev = null;
            tail.prev.next = tail;
            currentSize -= 1;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return head.next.val;
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return tail.prev.val;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }
}