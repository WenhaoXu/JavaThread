import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/*
Condition  用法与object的wait notify差不多
            condition.await();
            condition.signal();
            condition.signalAll();

 */
public class ReenterLockCondition implements  Runnable{
    public static ReentrantLock lock=new ReentrantLock();
    public static Condition condition=lock.newCondition();
    @Override
    public void run() {
        try{
            lock.lock();
            condition.await();
            System.out.println("thread is go on");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition tl=new ReenterLockCondition();
        Thread ti=new Thread(tl);
        ti.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
