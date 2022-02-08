public class OwnLinkedList<T> {
    private class Node{
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private long size;
    private Node head;
    private Node tail;

    public OwnLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addNode(T data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void addNode(T data, int index){
        Node newNode = new Node(data);
        if (index > size){
            addNode(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < index-1; i++){
            current = current.next;
        }
        Node nextNode = current.next;
        current.next = newNode;
        newNode.next = nextNode;
        size++;
    }

    public void deleteNode(int index){
        if (index > size){
            System.out.println("Такого элемента нет");
            return;
        }
        Node current = head;
        for (int i = 0; i < index-1; i++){
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void display(){
        Node current = head;
        if (head == null){
            System.out.println("Односвязный список пуст");
            return;
        }
        while (current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public void display(int index){
        if (index > size){
            System.out.println("Размер списка меньше, чем заданный индекс");
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        System.out.println(current.data);
    }
}
