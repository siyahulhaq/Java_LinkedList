class DoublyLinkedList<T> {
    Node head;
    Node tail;

    class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    public void push(T data) {
        Node newNode = new Node(data);
        Node temp = head;

        if (temp == null) {
            newNode.prev = temp;
            temp = newNode;
            tail = newNode;
            head = temp;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        newNode.prev = temp;
        temp.next = newNode;
        tail = newNode;
    }

    public void pop() {
        Node temp = head, prev = null;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp = prev;
        tail = temp;
    }

    public void unShift(T data) {
        Node temp = head, new_node = new Node(data);
        if (temp == null) {
            push(data);
            return;
        }
        new_node.next = temp;
        temp.prev = new_node;
        head = new_node;
    }

    public void shift() {
        Node temp = head;
        if (temp == tail) {
            pop();
            return;
        }
        temp = temp.next;
        temp.prev = null;
        head = temp;
    }

    public void delete(T data) {
        Node temp = this.head, prev = null;
        if (temp == tail && temp.data == data) {
            head = null;
            tail = null;
        }

        if (data == temp.data) {
            head = head.next;
            head.prev = null;
            return;
        }

        while (temp.next != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        if (temp.data == data) {
            if (temp == tail) {
                tail = prev;
                tail.next = null;
                return;
            }
            temp.next.prev = prev;
            prev.next = temp.next;
        }
    }

    public void insertAfter(T after, T new_data) {
        Node prev_Node = head, new_node = new Node(new_data);

        if (prev_Node != null && prev_Node.data == after) {
            new_node.next = prev_Node.next;
            new_node.prev = prev_Node;
            if (prev_Node == tail) {
                tail = new_node;
            }
            prev_Node.next = new_node;
            return;
        }

        while (prev_Node.next != null && prev_Node.data != after) {
            prev_Node = prev_Node.next;
        }

        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        new_node.next = prev_Node.next;

        prev_Node.next = new_node;

        new_node.prev = prev_Node;

        if (new_node.next != null)
            new_node.next.prev = new_node;
        else
            tail = new_node;
    }

    public void printNodes() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void printReversedNodes() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }

}