package com.test.testclass;

public class ThreadTest {
  synchronized public static void staticMethodLock(){
      try {
          System.out.println("进入静态方法锁..");
          Thread.sleep(5000);
      } catch (InterruptedException e) {
          e.printStackTrace();
          System.out.println("静态方法锁出错..");
      }
      System.out.println("退出静态方法锁..");
  }

    synchronized public void methodLock(){
        try {
            System.out.println("进入方法锁..");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("方法锁出错..");
        }
        System.out.println("退出方法锁..");
    }

  public static void classLock(){
      synchronized (ThreadTest.class){//锁住class类
          try {
              System.out.println("进class类锁..");
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              e.printStackTrace();
              System.out.println("进class类锁出错..");
          }
          System.out.println("退出class类锁..");
      }

  }

  public void startNormal() throws InterruptedException {
      int i = 1;
      while (i < 11){
          Thread.sleep(500);
          System.out.println("普通方法执行" + i++);
      }
  }


  /**
   * 结论方法锁
   * */
}
