package com.anwesh.impl;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Scheduler {

    private static Scheduler scheduler = new Scheduler();

    private ConcurrentLinkedQueue<SchedulerItem> schedulerItems = new ConcurrentLinkedQueue<>();

    private Scheduler() {
        start();
    }

    public static Scheduler getInstance() {
        return scheduler;
    }

    public void schedule(Executable executable, long delay) {
        schedulerItems.add(new SchedulerItem(executable, delay));
    }

    private void start() {
        new Thread(() -> {
            while(true) {
                schedulerItems.stream().filter(item -> item.shouldExecute()).forEach(item -> item.shouldExecute());
            }
        }).start();
    }
}
