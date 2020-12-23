package com.test;

import com.test.testclass.ThreadTest;

public class ClassLock {
    public static void main(String[] args) throws InterruptedException {

        ThreadTest threadTest = new ThreadTest();

        //类锁5s
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
     * 结论，静态类锁对对象的普通方法执行无影响，类锁是类对象的锁（class对象）
     * */

}
