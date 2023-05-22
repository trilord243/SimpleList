
package listexercise;


public class Node {
    private Node next;
    private Object element;
    
    public Node(Object element){
        this.next=null;
        this.element=element;
    }
    
    //Getters and setters

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
    
    
    
}
