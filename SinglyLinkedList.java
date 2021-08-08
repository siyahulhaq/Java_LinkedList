import java.util.ArrayList;

class SinglyLinkedList <T> {
    public Node head;
    public Node tail;
    class Node {
        T data;
        Node next;
        Node (T data) {
            this.data = data;
        }
    }

    @Override
    public String toString() {
        return this.head.data.toString();
    }

    public void addNode (T data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }

    public void addAfterNode(T after, T data) {
        Node temp = this.head, prev = null;
        Node newNode = new Node(data);
        
        if (temp.data == after) {
            if(tail == temp){
                tail = newNode;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            return;
        }

        while (temp.next != null && temp.data != after) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        if (temp.data == after) {
            if(temp == tail){
                tail.next = newNode;
                tail = newNode;
                return;
            }
           newNode.next = temp.next;
           temp.next = newNode;
           prev.next = temp;
        }
    }

    public void printNodes () {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public ArrayList<T> toArrayList() {
        Node temp = this.head;
        ArrayList<T> list = new ArrayList<T>();
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        return list;
    }

    public void deleteNode (T data) {
        Node temp = this.head, prev = null;

        if(temp != null && temp.data == data) {
            this.head = temp.next;
            return;
        } else if (temp == null) {
            System.out.println("Can't deleteNode from empty Linked List");
            return;
        }

        while (temp.next != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp.next == null) {
            return;
        }

        if (temp.data == data) {
            if(temp == tail){
                tail = prev;
                tail.next = null;
                return;
            }
            prev.next = temp.next;
        }
    }
}