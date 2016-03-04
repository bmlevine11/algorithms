import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created on 2/12/15.
 * @author brianlevine
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int N;       //size
    private Item[] queue;

    private void resize(int capacity){
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N ; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }
    /**
     *Constructs an empty randomized queue
     */
    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
    }

    /**
     *Is the queue empty?
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     *Return the number of items on the queue
     */
    public int size() {
        return N;
    }

    /**
     *Add the item
     */
    public void enqueue(Item item) {
        if(item == null) throw new NullPointerException();
        if(N == queue.length) resize(2*queue.length);
        queue[N++] = item;
    }

    /**
     *Remove and return a random item
     */
    public Item dequeue() {
        if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
        int index;
        if(N > 1)
            index = StdRandom.uniform(N);
        else
            index = 0;
        Item item = queue[index];
        queue[index] = null;

        if(index != N-1) {
            for (int i = index; i < N-1; i++) {
                queue[i] = queue[i + 1];
            }
        }
        queue[N-1] = null;
        N--;
        if(N > 0 && N == queue.length/4) resize(queue.length/2);
        return item;
    }
    /**
     * Return (but do not remove) a random item
     */
    public Item sample() {
        if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
        else return queue[StdRandom.uniform(N)];
    }

    /**
     *Return an independent iterator over items in random order
     */
    public Iterator<Item> iterator()  { return new RandomIterator(); }

    private class RandomIterator implements Iterator<Item>{
        private int i;
        public RandomIterator(){
            i = N;
        }
        public boolean hasNext()  { return i > 0;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return queue[StdRandom.uniform(i--)];
        }
    }

    /**
     *
     */
    public static void main(String[] args)  {
//        int[] intArray = {1,2,3,4,5,6,7,8,9,10,11,12};
//        RandomizedQueue test = new RandomizedQueue();
//
//        for (int i = 0; i < intArray.length; i++) {
//            test.enqueue(intArray[i]);
//            System.out.println("Enqueued "+intArray[i]);
//        }
//
//        test.dequeue();
//        test.enqueue(9);
//        test.dequeue();
//        test.dequeue();
//        test.dequeue();
//        test.dequeue();
//        test.dequeue();
//        test.dequeue();
//        test.dequeue();
//        test.dequeue();
//
//
//        for (int i = 0; i < intArray.length; i++) {
//            test.enqueue(intArray[i]);
//            System.out.println("Enqueued "+intArray[i]);
//        }
    }
}
