package ru.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class Spam extends Thread {

  private int[] latency;
  private String[] messages;

  public Spam(int[] latency, String[] messages) {
    if (latency.length != messages.length) {
      throw new IllegalArgumentException("Error! Arrays of latency and messages aren't equal!!!");
    }
    this.latency = latency;
    this.messages = messages;
    start();
  }


  @Override
  public void run() {
    try {
      for (int i = 0; i < messages.length; i++) {
        TimeUnit.MILLISECONDS.sleep(latency[i]);
        System.out.println(messages[i]);
      }
    } catch (InterruptedException ex) {
    }
  }


  static class Listener extends Thread {

    Thread thread;


    public static final InputStream IN_DEFAULT = System.in;


    public Listener(Thread thread) {
      super();
      setDaemon(true);
      this.thread = thread;
      start();
    }

    @Override
    public void run() {
      try {
        while (true) {
          if (System.in.available() > 0 && System.in.read() == '\n') {
            System.setIn(IN_DEFAULT);
            thread.interrupt();
          }
        }
      } catch (IOException e) {
      }
    }
  }

  public static void main(String[] args) {
    int[] latency = { 1000, 1000, 1000, 1000, 1000, 1000 };
    String[] messages = { "First", "Second", "Third", "Fourth", "Fifth", "Sixth" };
    Thread spam = new Spam(latency, messages);
    Thread listener = new Listener(spam);

  }

}