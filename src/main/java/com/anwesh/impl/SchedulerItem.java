package com.anwesh.impl;


public class SchedulerItem {

    private long delay;

    private Executable task;

    private long currTime;

    public SchedulerItem(Executable task, long delay) {
        this.task = task;
        this.delay = delay;
        currTime = System.currentTimeMillis();
    }

    public void execute() {
        task.execute();
        currTime = System.currentTimeMillis();
    }

    public boolean shouldExecute() {
        return (System.currentTimeMillis() - currTime) >= delay;
    }

}
