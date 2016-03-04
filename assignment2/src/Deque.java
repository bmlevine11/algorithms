import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Created on 2/11/15.
 * @author brianlevine
 */
public class Deque<Item> implements Iterable<Item> {

    private int N; //queue size
    private Node first;
    private Node last;

    private class Node{

        private Node next;
        private Node previous;
        private Item item;
    }
    /**
    *
    * Constructs an empty deque.
    */
    public Deque() {
        first = null;
        last = null;
        N = 0;
    }

    /**
     *
     * Checks if the deque is empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     *
     * Returns the number of items on the deque
     */
    public int size() {
        return N;
    }

    /**
     *
     * Adds an item to the front
     */
    public void addFirst(Item item) {
        if(item == null) throw new NullPointerException();
        Node oldfirst = first;
        first = new Node();
        first.next = oldfirst;
        first.item = item;
        if(last == null){
            last = first;
        }
        else{
            oldfirst.previous = first;
        }
        N++;
    }

    /**
     *
     * Adds an item to the end
     */
    public void addLast(Item item) {
        if(item == null) throw new NullPointerException();
        Node oldlast = last;
        last = new Node();
        last.previous = oldlast;
        last.item = item;
        if(first == null){
            first = last;
        }
        else{
            oldlast.next = last;
        }
        N++;
    }

    /**
     *
     * Removes and returns the item from the front
     */
    public Item removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if(N == 0) last = null;
        else first.previous = null;
        return item;
    }

    /**
     *
     * Removes and returns the item from the end
     */
    public Item removeLast() {
        if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
        Item item = last.item;
        last = last.previous;
        N--;
        if(N == 0) first = null;
        else last.next = null;
        return item;
    }

    /**
     *
     * Returns an iterator over items in order from front to end
     */
    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {

    }
}