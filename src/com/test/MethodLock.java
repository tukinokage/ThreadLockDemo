package com.test;

import com.test.testclass.ThreadTest;

public class MethodLock {
    public static void main(String[] args) throws InterruptedException {

        ThreadTest threadTest = new ThreadTest();

        //方法锁5s
        new Thread(){
            @Override
            public void run() {
                threadTest.methodLock();
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

    /**结论，方法锁对对象锁的普通方法执行有影响，对象锁和当前类的锁使用同一个锁
     * */
}
