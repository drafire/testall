package com.drafire.testall.Sevice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HashMapTest {

    private final HashMap hashMap = new HashMap();
    private final Hashtable hashtable = new Hashtable();

    private final String HASH_MAP_KEY = "abc";

    private final String HASH_TABLE_KEY = "123";

    @Test
    public void testNull() {
        hashMapPutNull();
        hashTablePushNull();
    }

    private void hashMapPutNull() {
        //hashmap可以使用null 来做key或者value
        // key如果为null，则置0；
        //value如果为null，不会像hashtable 那样抛出NullException
        hashMap.put("name", "扎根三");
        hashMap.put(null, "里斯");
        hashMap.put("1", null);
        System.out.println(hashMap.toString());
    }

    private void hashTablePushNull() {

        hashtable.put("name", "扎根三");
        //hashTable不允许使用null 作为key 或者value
        //hashTable是线程安全的
        hashtable.put(null, "里斯2");
        hashtable.put("2", null);
        System.out.println(hashtable.get("name"));
    }

    @Test
    public void testThreadSafe() {
        for(int j=0 ;j<10;j++){
            for (int i = 0; i < 10; i++) {
                new Thread(new MyHashMapThread(i)).start();
                new Thread(new MyHashTableThread(i)).start();
            }
            System.out.println("hashMap.get("+HASH_MAP_KEY+")->"+ hashMap.get(HASH_MAP_KEY));
            System.out.println("hashtable.get("+HASH_TABLE_KEY+")->"+ hashtable.get(HASH_TABLE_KEY));
        }

    }

    private class MyHashMapThread implements Runnable {
        private int value;

        public MyHashMapThread(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            hashMap.put(HASH_MAP_KEY, value);
        }
    }

    private class MyHashTableThread implements Runnable {
        private int value;

        public MyHashTableThread(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            hashtable.put(HASH_TABLE_KEY, value);
        }
    }
}
