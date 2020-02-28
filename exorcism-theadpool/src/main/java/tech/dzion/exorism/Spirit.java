package tech.dzion.exorism;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Spririt
 * @Author Rao Shiqi
 * @Date 2020/1/31 16:38
 * @Description TODO
 */

@Slf4j
public class Spirit implements Runnable {
    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        log.info("im running " + counter.incrementAndGet());
    }
}
