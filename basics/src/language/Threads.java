package language;

/**
 * Based on http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html
 */
public class Threads {

  public static void main(String[] args) {

    LittleThread littleThread = new LittleThread();
    BigThread bigThread = new BigThread();
    littleThread.start();
    bigThread.start();
    
    Thread runnable = new Thread(new RunnableThread());
    runnable.start();
  }

  public static class LittleThread extends Thread {

    public void run() {
      for(int i = 0; i < 10; i++) {
        System.out.println("little: " + i);
      }
    }
  }

  public static class BigThread extends Thread {

    public void run() {
      for(int i = 0; i < 10; i++) {
        System.out.println("big: " + i);
      }
    }
  }

  public static class RunnableThread implements Runnable {

    public void run() {
      for(int i = 0; i < 10; i++) {
        System.out.println("runnable: " + i);
      }      
    }
  }
}
