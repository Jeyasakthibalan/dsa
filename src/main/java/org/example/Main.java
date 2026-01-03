package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@Slf4j
public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world");
        Mono<String[]> mono = Mono.just(new String[]{"Hello", "World"});
        Mono<String[]> mono1 = Mono.just(new String[]{"Flux", "Mono"});
        Mono<String[]> mono3 = Mono.just(new String[]{"Flux3", "Mono3"});
//        Mono.zip(mono1, mono3).map(a ->  a.getT1()+" "+a.getT2()).subscribe(m -> Arrays.stream(m.getT1()).forEach(System.out::println));
        //mono.subscribe(m -> Arrays.stream(m).forEach(System.out::println));
        Flux.zip(mono, mono3)
            .map(m -> Arrays.stream(m.getT1())
                            .toList())
            .subscribe(System.out::println);
//        Flux<String> flux1 = Flux.just("Jsb", "123", "25");
//        Flux<String> flux2 = Flux.just("Poo", "456", "25");
//        Flux.zip(flux1, flux2)
//            .map((f) -> f.getT1() + " " + f.getT2())
//            .map(Employee::new)
//            .map(Employee::getName)
//            .subscribe(System.out::println);
//        Flux.zip(flux1, flux2)
//            .map(Tuple2::getT1)
//            .map(Employee::new)
//            .map(Employee::getName)
//            .subscribe(System.out::println);
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"L1", "L2"});
        list.add(new String[]{"L3", "L4"});
        //System.out.println(list.stream());
        List<String> list1 = list.stream()
                                 .flatMap(Arrays::stream)
                                 .collect(Collectors.toList());
        System.out.println(list1);

        list.stream()
            .flatMap(Arrays::stream)
            .forEach(System.out::println);

        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            final int a = 5 + 3;
            System.out.println("Thread 1 " + a);
            return a;
        }, Executors.newFixedThreadPool(2));

        cf.thenAccept(System.out::println);
        cf.join();

        Thread t1 = new Thread(() -> {
            Sample sam = new Sample();
            for (int i = 0; i < 50; i++) {
                try {
                    sam.meterInc();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            Sample sam = new Sample();
            for (int i = 0; i < 50; i++) {
                try {
                    sam.meterInc();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        ExecutorService ex1 = Executors.newCachedThreadPool();
        CompletableFuture.supplyAsync(() -> {
                             int a = 0;
                             try {
                                 Thread.sleep(200);
                             } catch (InterruptedException e) {
                                 throw new RuntimeException(e);
                             }
                             System.out.println(Thread.currentThread()
                                                      .getName());
                             for (int i = 0; i < 50; i++) a++;
                             return a;
                         }, ex1)
                         .whenComplete((a, s) -> ex1.shutdown());
        //.thenAccept(System.out::println)


        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Darwin"));
        emp.add(new Employee("Hume"));

        Collections.sort(emp, Comparator.comparingInt(x -> x.getName()
                                                            .length()));
        emp.stream()
           .map(Employee::getName)
           .forEach(System.out::println);
        System.out.println(emp);
        for (Thread t : Thread.getAllStackTraces()
                              .keySet()) {
            System.out.println(t.getName() + " | daemon=" + t.isDaemon() + " | state=" + t.getState());
        }

        //cf.
    }
}

@Getter
@Setter
class Employee {
    public String name;

    //    public String number;
//    public String age;
    public Employee(String name) {
        this.name = name;
    }

}

class Sample {
    private int meter;

    public void meterInc() throws InterruptedException {
        synchronized (Sample.class) {
            this.meter += 1;
            System.out.println("Thread " + Thread.currentThread()
                                                 .getName() + " on " + this.meter + " meter");
        }
    }
}