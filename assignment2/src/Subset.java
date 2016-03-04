/**
 * Created by brianlevine on 2/12/15.
 */
public class Subset {

    public static void main(String[] args) {

        int k = java.lang.Integer.parseInt(args[0]);
        RandomizedQueue scan = new RandomizedQueue();

        while(!StdIn.isEmpty()){
            scan.enqueue(StdIn.readString());
        }

        for (int i = 0; i < k; i++) {
            scan.dequeue();
        }
    }
}
