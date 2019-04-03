package com.drafire.testall.Sevice;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ListTest {
    private final ArrayList arrayList = new ArrayList();
    private final LinkedList linkedList = new LinkedList();
    private final Vector vector = new Vector();

    //初始化容量
    private static int INITIAL_SIZE = 10000000;
    //累计插入元素的次数
    private static int ADD_SIZE = 1000;
    //插入的元素
    private static int ADD_NUM = 3;
    //插入元素的位置
    private static int ADD_INDEX = 988;
    //线程数量
    private static final int THREAD_SIZE = 10;
    //修改元素的位置
    private final int CHANGE_INDEX = 5;

    //测试线程安全
    @Test
    public void testThreadSafe() {
        init();
        testArrayListThreadSafe();
        testLinkedListThreadSafe();
        testVectorThreadSafe();
    }

    //测试性能
    @Test
    public void testNature() {
        setArrayList();
        setLinkedList();

        testAddArrayList();
        testAddLinkList();

        testQueryArrayListItem();
        testQueryLinkedListItem();
    }

    private void init() {
        for (int i = 0; i < THREAD_SIZE; i++) {
            arrayList.add(i, THREAD_SIZE + i);
            linkedList.add(i, THREAD_SIZE + i);
            vector.add(i, THREAD_SIZE + i);
        }
    }

    private void testArrayListThreadSafe() {
        MyArrayListThread[] myArrayListThreads = new MyArrayListThread[THREAD_SIZE];
        for (int i = 0; i < THREAD_SIZE; i++) {
            myArrayListThreads[i] = new MyArrayListThread(i);
        }
        for (int i = 0; i < THREAD_SIZE; i++) {
            Thread thread = new Thread(myArrayListThreads[i]);
            thread.start();
        }
        System.out.println("arrayList[" + CHANGE_INDEX + "]=" + arrayList.get(CHANGE_INDEX));
    }

    private void testLinkedListThreadSafe() {
        MyLinkedListThread[] myLinkedListThreads = new MyLinkedListThread[THREAD_SIZE];
        for (int i = 0; i < THREAD_SIZE; i++) {
            myLinkedListThreads[i] = new MyLinkedListThread(i);
        }

        for (int i = 0; i < THREAD_SIZE; i++) {
            //不要调用run方法。因为run()实际上只是跑了主进程一个线程
            Thread thread = new Thread(myLinkedListThreads[i]);
            thread.start();
        }
        System.out.println("linkedList[" + CHANGE_INDEX + "]=" + linkedList.get(CHANGE_INDEX));
    }

    private void testVectorThreadSafe() {
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

    private void setArrayList() {
        Date st = new Date();
        for (int i = 0; i < INITIAL_SIZE; i++) {
            arrayList.add(i);
        }
        Date et = new Date();
        System.out.println("arrayList 初始化使用时间：" + (et.getTime() - st.getTime()));
    }

    private void setLinkedList() {
        Date st = new Date();
        for (int i = 0; i < INITIAL_SIZE; i++) {
            linkedList.add(i);
        }
        Date et = new Date();
        System.out.println("linkedList 初始化使用时间：" + (et.getTime() - st.getTime()));
    }

    private void testAddArrayList() {
        //ArrayList 本质是一个数组。集合的优势在于，追加元素到数组末尾的时候速度快，同时检索元素的速度也快。
        // 但是如果要插入一个元素到数组之间，就慢；另外，如果要追加的元素数量多于数组的容量，则需要频繁扩容
        //使用Arrays.Arrays.copyOf 重新创建一个合适容量的数组
        Date st = new Date();
        for (int i = 0; i < ADD_SIZE; i++) {
            arrayList.add(ADD_INDEX, ADD_NUM);
        }
        Date et = new Date();
        System.out.println("arrayList在" + ADD_INDEX + "处添加元素：" + ADD_NUM + "," + ADD_SIZE + "次，使用时间：" + (et.getTime() - st.getTime()));
    }

    private void testAddLinkList() {
        //LinkedList本质是一个链表。list的优势在于，没有容量的概念，追加元素速度快
        Date st = new Date();
        for (int i = 0; i < ADD_SIZE; i++) {
            linkedList.add(ADD_INDEX, ADD_NUM);
        }
        Date et = new Date();
        System.out.println("linkedList在" + ADD_INDEX + "处添加元素：" + ADD_NUM + "," + ADD_SIZE + "次，使用时间：" + (et.getTime() - st.getTime()));
    }

    private void testQueryArrayListItem() {
        Date st = new Date();
        for (int i = 0; i < ADD_SIZE; i++) {
            arrayList.get(new Random().nextInt(INITIAL_SIZE));
        }
        Date et = new Date();
        System.out.println("arrayList随机检索元素：" + ADD_SIZE + "次，使用时间：" + (et.getTime() - st.getTime()));
    }

    private void testQueryLinkedListItem() {
        Date st = new Date();
        for (int i = 0; i < ADD_SIZE; i++) {
            linkedList.get(new Random().nextInt(INITIAL_SIZE));
        }
        Date et = new Date();
        System.out.println("linkedList随机检索元素：" + ADD_SIZE + "次，使用时间：" + (et.getTime() - st.getTime()));

    }

    private class MyArrayListThread implements Runnable {

        private int value;

        public MyArrayListThread(int v) {
            this.value = v;
        }

        @Override
        public void run() {
            arrayList.set(CHANGE_INDEX, value);
        }
    }

    private class MyLinkedListThread implements Runnable {

        private int value;

        public MyLinkedListThread(int v) {
            this.value = v;
        }

        @Override
        public void run() {
            linkedList.set(CHANGE_INDEX, value);
        }
    }

    private class MyVectorThread implements Runnable {

        private int value;

        public MyVectorThread(int v) {
            this.value = v;
        }

        @Override
        public void run() {
            vector.set(CHANGE_INDEX, value);
        }
    }
}
