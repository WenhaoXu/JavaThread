package producerAndConsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<PCData>queue=new LinkedBlockingDeque<>(10);
        Producer producer=new Producer(queue);
        Producer producer1=new Producer(queue);
        Producer producer2=new Producer(queue);
        Consumer consumer=new Consumer(queue);
        Consumer consumer1=new Consumer(queue);
        Consumer consumer2=new Consumer(queue);
        ExecutorService service=Executors.newCachedThreadPool();
        service.execute(producer);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(consumer);
        service.execute(consumer1);
        service.execute(consumer2);
        Thread.sleep(10*1000);
        producer.stop();
        producer1.stop();
        producer2.stop();
        Thread.sleep(3000);
        service.shutdown();
    }
}
