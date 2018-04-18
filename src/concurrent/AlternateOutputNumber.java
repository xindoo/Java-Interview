import java.util.concurrent.atomic.AtomicInteger;

public class AlternateOutputNumber {
    private AtomicInteger cnt = new AtomicInteger();

    class ThreadEven extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (cnt) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadEven " + cnt);
                    cnt.addAndGet(1);
                    cnt.notify();
                    try {
                        cnt.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (cnt.get()> 100) {
                        return;
                    }
                }
            }
        }
    }
    class ThreadOdd extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (cnt) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadOdd  " + cnt);
                    cnt.addAndGet(1);
                    cnt.notify();
                    try {
                        cnt.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (cnt.get() > 100) {
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args)  {
        ThreadA test = new ThreadA();
        ThreadEven threadEven = test.new ThreadEven();
        ThreadOdd threadOdd = test.new ThreadOdd();
        threadEven.start();
        threadOdd.start();
    }
}