import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by brianlevine on 3/20/14.
 */
public class Deque<Item> implements Iterable<Item> {

    /**
     * TODO: Decide on data structure (definitely linked list)
     * pointer to both ends of list
     * instance variables
     *
     *
     */

    private int size; //size of deque
    private Node first; //first link in deque
    private Node last; // last link in deque

    private class Node{
        private Item item;
        private Node next;
        private Node previous;

    }

    public Deque(){
        size = 0;
        first = null;
        last = null;
    }

    /**
     *
     * @return true if next entry == null
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     *
     * @return number of entries in queue
     * @param size
     */
    public int size(){
        return size;
    }

    /**
     * Take an item and add it to the front of the queue
     * @param item
     */
    public void addFirst(Item item){
        if(item == null){throw new NullPointerException();}

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.previous = null;

        if(oldFirst == null){
            first.next = null;
            last = first;
        }

        else {
            oldFirst.previous = first;
            first.next = oldFirst;
        }
        size++;
    }

    /**
     * Take an item and add it to the end of the queue
     * @param item
     */
    public void addLast(Item item){
        if(item == null){throw new NullPointerException();}

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()){
          first=last;
        }

        else {
            oldLast.next = last;
            last.previous = oldLast;
        }

        size++;
    }

    /**
     * remove the first item
     * @return
     */
    public Item removeFirst(){
        if(isEmpty()){throw new NoSuchElementException();}
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    /**
     * remove the last item
     * @return
     */
    public Item removeLast(){
        if(isEmpty()){throw new NoSuchElementException();}
        Item item = last.item;
        last = last.previous;
        size--;
        return item;
    }

    /**
     * return an iterator over items in order from front to end
     * @return
     */
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

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

    public static void main(String[] args){
        int n = 10;
        Deque test = new Deque();
        for (int i = 1; i <= n; i++){
            test.addFirst(i);
        }

        for (int i = 1; i <= n; i++){
            StdOut.print(test.removeLast());
        }
    }// End main


}// End class
