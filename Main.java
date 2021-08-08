class Main {
    public static void main(String[] args) {
        System.out.println(args.toString());
        DoublyLinkedList<User> dLinkedList = new DoublyLinkedList<User>();
        User haq = new User("Haq", "siyahulhaq124@gmail.com");
        User siyahulHaq = new User("Siyahul Haq", "siyahulhaq091@gmail.com");
        User sinan = new User("Sinan", "sinan@gmail.com");
        User suniya = new User("Suniya", "sinan@gmail.com");
        dLinkedList.push(haq);
        dLinkedList.push(sinan);
        dLinkedList.push(suniya);
        dLinkedList.push(siyahulHaq);
        dLinkedList.pop();
        dLinkedList.push(siyahulHaq);
        dLinkedList.printReversedNodes();
    }
}