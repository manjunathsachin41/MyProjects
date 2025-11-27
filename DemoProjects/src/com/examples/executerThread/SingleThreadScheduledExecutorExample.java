package com.examples.executerThread;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorExample {

    public static void main(String[] args) {
        // Create a single-threaded scheduled executor
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Schedule a task to run once after a 3-second delay
        System.out.println("Scheduling task 1 to run after 3 seconds...");
        // It runs only once
        scheduler.schedule(() -> {
            System.out.println("Task 1 executed after delay by thread: " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        // Schedule a task to run periodically, starting after a 1-second delay
        // and repeating every 2 seconds
        System.out.println("Scheduling task 2 to run periodically (initial delay 1s, repeat every 2s)...");
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Task 2 executed periodically by thread: " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        // Keep the main thread alive for a while to observe the scheduled tasks
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Shut down the scheduler gracefully
        scheduler.shutdown();
        System.out.println("Scheduler shut down.");
    }
}