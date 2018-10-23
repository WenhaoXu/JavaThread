import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static  Object u=new Object();
    static ChangeobjectThread t1=new ChangeobjectThread("t1");
    static ChangeobjectThread t2=new ChangeobjectThread("t2");

    public  static  class ChangeobjectThread extends Thread{
        public ChangeobjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in "+getName());
                LockSupport.park();
                System.out.println(getName()+"解除了阻塞");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
    }
}
