@SuppressWarnings("Unchecked")
public class Stack <T>{
    private Node<T> top = null;
    private int size = 0;
    private T data;
    private Node<T> head = null;


    private static class Node<T>{
        private final T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }
    
     public T getTop(){
        return top.data;
    }
  
    //Complexity of o(1)
    public void push(T element){
        if(isEmpty()){
            head = top = new Node<T>(element, null);
        }else{
            Node<T> temp = new Node<>(element, null);

            temp.next = head;
            head = top = temp;
        }
        size++;
    }
    
    //Complexity of o(1)
    public T pop(){
        if (isEmpty()) throw new RuntimeException("Empty list");

        T data = head.data;

        head = top = head.next;
        size--;

        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> trav = head;

        while(trav != null){
            sb.append(trav.data).append(", ");
            trav = trav.next;
        }
        sb.append("]");

        return sb.toString();
    }
}
