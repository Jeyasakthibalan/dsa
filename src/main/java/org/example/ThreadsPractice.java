package org.example;

import java.util.concurrent.*;

public class ThreadsPractice implements Runnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread()
                                                              .getName()));
        t1.start();
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> hold = service.submit(() -> 1);
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello world");
        System.out.println(hold.get() + " " + hold.isCancelled());
        cf.thenApply(String::toUpperCase)
          .thenAccept(System.out::println);
        service.shutdownNow();

        ThreadsPractice tp = new ThreadsPractice();
        Thread t2 = new Thread(tp);
        t2.start();
    }

    public void run() {
        System.out.println(Thread.currentThread()
                                 .getName() + " from Run");
        samplePrint();
    }

    public void samplePrint() {
        System.out.println(Thread.currentThread()
                                 .getName() + " called");
    }
}
