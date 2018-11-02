public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(Object obj) throws Exception {

        if(obj == null) {
            throw new Exception("Cannot add object");
        }

        if(head == null) {
            head = new Node(obj, head);
            tail = head;
            size++;
            return;
        }

        tail.next = new Node(obj, tail.next);
        size++;
    }

    @Override
    public void add(int pos, Object obj) throws Exception {

        if(pos < 0 || pos > size){
            throw new Exception("Invalid index");
        }

        if(obj == null) {
            throw new Exception("Cannot add object");
        }

        if(pos == 0){
            head = new Node(obj, head);
            tail = head;
            size++;
            return;
        }

        Node prev = head;
        for(int i = 0; i < pos && prev.next != null; i++) {
            prev = prev.next;
        }

        prev.next = new Node(obj, prev.next);
        size++;
    }

    @Override
    public Object get(int pos) throws Exception {
        if(pos < 0 || pos > size){
            throw new Exception("Invalid position");
        }

        Node curr = head;
        for(int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public Object remove(int pos) throws Exception {

        if(pos < 0 || pos > size) {
            throw new Exception("Invalid position");
        }

        if(head == null) {
            return null;
        }

        if(pos == 0){
            Node node = head;
            head = head.next;
            size--;
            return node.data;
        }

        Node curr = head;
        for(int i = 0; i < pos - 1; i++) {
            curr = curr.next;
        }
        
        Node temp = curr.next;
        curr.next = curr.next.next;
        size--;
        return temp.data;
    }

    @Override
    public int size() {

        return size;
    }

    private class Node {
        Node next;
        Object data;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}