package ru.java;

public class MyThread implements Runnable {
  public static void main(String[] args) {
    System.out.println("Main thread started...");
    new JThread("JThread").start();
    for (int i = 1; i < 6; i++) {
      new JThread("JThread " + i).start();
      System.out.println("Main thread finished...");
    }
  }

  @Override
  public void run() {
    System.out.printf("%s started... \n", Thread.currentThread().getName());
    try{
      Thread.sleep(500);
    }
    catch(InterruptedException e){
      System.out.println("Thread has been interrupted");
    }
    System.out.printf("%s finished... \n", Thread.currentThread().getName());
  }
  }
