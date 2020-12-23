package com.test;

import com.test.testclass.ThreadTest;

public class StaticMethodLock {
    public static void main(String[] args)  {

        ThreadTest threadTest = new ThreadTest();

        //静态方法锁5s
        new Thread(){
            @Override
            public void run() {
                ThreadTest.staticMethodLock();
            }
        }.start();


        //执行普通方法
        new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (threadTest){
                        threadTest.startNormal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
/***
 * 结论，静态方法锁对对象的普通方法执行无影响，静态方法锁属于是类对象的锁（class对象）
 * */
}
