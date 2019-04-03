package com.drafire.testall.Sevice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Vector;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VectorTest {
    private final Vector vector = new Vector();


    //修改元素的位置
    private final int CHANGE_INDEX = 5;
    //线程数量
    private static final int THREAD_SIZE = 10;
    //测试线程安全
    @Test
    public void testThreadSafe() {
        for (int i = 0; i < THREAD_SIZE; i++) {
            vector.add(i, THREAD_SIZE + i);
        }
        MyVectorThread[] myVectorThreads = new MyVectorThread[THREAD_SIZE];
        for (int i = 0; i < THREAD_SIZE; i++) {
            myVectorThreads[i] = new MyVectorThread(i);
        }
        for (int i = 0; i < THREAD_SIZE; i++) {
            //不要调用run方法。因为run()实际上只是跑了主进程一个线程
            Thread thread = new Thread(myVectorThreads[i]);
            thread.start();
        }
        System.out.println("vector[" + CHANGE_INDEX + "]=" + vector.get(CHANGE_INDEX));
    }

    private class MyVectorThread implements Runnable {
        private int value;
        public MyVectorThread(int v) { this.value = v; }
        @Override
        public void run() { vector.set(CHANGE_INDEX, value); }
    }
}
