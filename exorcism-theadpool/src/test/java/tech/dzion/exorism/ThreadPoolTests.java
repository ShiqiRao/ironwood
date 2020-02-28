package tech.dzion.exorism;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPoolTests
 * @Author Rao Shiqi
 * @Date 2020/1/31 16:29
 * @Description TODO
 */
@Slf4j
public class ThreadPoolTests {

    @Test
    void testFixedThreadPool() {
        ExecutorService service = Executors.newFixedThreadPool(4);
        runTasks(service);
    }

    @Test
    void testCachedThreadPool() {
        ExecutorService service = Executors.newCachedThreadPool();
        runTasks(service);
    }

    @Test
    void testSingleThreadPool() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        runTasks(service);
    }

    @Test
    void testScheduleThreadPool() throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        long taskNum = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        AtomicInteger counter = new AtomicInteger(0);
        for (long i = 0; i < taskNum; i++) {
            service.scheduleWithFixedDelay(() -> {
                log.info("im running " + counter.incrementAndGet());
                countDownLatch.countDown();
            }, 1000, 2000, TimeUnit.MILLISECONDS);
        }
        countDownLatch.await();
    }

    @Test
    void testCountDownLatch() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        AtomicInteger counter = new AtomicInteger(0);
        long taskNum = 1000;
        for (long i = 0; i < taskNum; i++) {
            service.execute(() -> {
                log.info("im running " + counter.incrementAndGet());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("main-thread");
        service.shutdown();
    }

    @Test
    void testThreadPoolExecutor() {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService service = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS
                , workQueue, new ThreadFactory() {
            private AtomicInteger counter = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "test-" + counter.incrementAndGet());
            }
        }, (r, executor) -> log.error(r.toString() + "rejected"));
        runTasks(service);
    }

    @Test
    void testCyclicBarriers() {
        ExecutorService service = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(1000);
        AtomicInteger counter = new AtomicInteger(0);
        long taskNum = 1000;
        for (long i = 0; i < taskNum; i++) {
            service.execute(() -> {
                log.info("im running " + counter.incrementAndGet());
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        log.info("main-thread");
        service.shutdown();
    }

    @Test
    void testSemaphore() {
        ExecutorService service = Executors.newCachedThreadPool();
        long taskNum = 1000;
        AtomicInteger counter = new AtomicInteger(0);
        Semaphore semaphore = new Semaphore(4);
        for (long i = 0; i < taskNum; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    log.info("im running " + counter.incrementAndGet());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void runScheduledTask(ScheduledExecutorService service) {
        long taskNum = 1000;
        for (long i = 0; i < taskNum; i++) {
            service.scheduleWithFixedDelay(new Spirit(), 1000, 2000, TimeUnit.MILLISECONDS);
        }
    }

    private void runTasks(ExecutorService service) {
        long taskNum = 1000;
        for (long i = 0; i < taskNum; i++) {
            service.execute(new Spirit());
        }
    }

}
