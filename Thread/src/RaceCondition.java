 class Counter {

    private int count = 0;

    public void increment() {
        synchronized (this){
            count++;
        }

    }

    public int getCount() {
        return count;
    }
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable task = () -> {

            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count = " + counter.getCount());
    }
}
