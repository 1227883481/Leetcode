package hot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wgl
 * @create 2021-08-15 11:53
 */
public class LRUCache {

    Map<Integer, Integer> cache = new HashMap<>();
    Map<Integer, Integer> lifeMap = new HashMap<>();
    int maxCap;
    // int capacity;
    public LRUCache(int capacity) {
        this.maxCap = capacity;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
//        System.out.println(lruCache.lifeMap.size());
//        System.out.println(lruCache.cache.size());

//        lruCache.get(1);
        lruCache.put(2,3);
        lruCache.put(4,1);
//        System.out.println(lruCache.lifeMap.size());
//        System.out.println(lruCache.cache.size());

        lruCache.get(1);
        lruCache.get(2);
//        lruCache.put(4,4);
        System.out.println(lruCache.lifeMap.size());
        System.out.println(lruCache.cache.size());

    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int curLife = lifeMap.get(key);
            //如果存在，返回V，修改年龄
            for (Map.Entry<Integer,Integer> entry : lifeMap.entrySet()) {
                int curEntryLife = entry.getValue();
                int entryKey = entry.getKey();
                if (curEntryLife < curLife) {
                    lifeMap.put(entryKey, curEntryLife + 1);
//                    entry.setValue(entry.getValue() + 1);
                }
                if (curEntryLife == curLife) {
                    lifeMap.put(entryKey, 1);
//                    entry.setValue(1);
                }
            }
            return cache.get(key);
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) { //如果已经存在要插入的值
            cache.put(key, value);
            int life = lifeMap.get(key);
            for (Map.Entry<Integer, Integer> entry : lifeMap.entrySet()) {
                int curEntryLife = entry.getValue();
                if (curEntryLife == life) {
                    lifeMap.put(key, 1);
                }
                if (curEntryLife < life) {
                    lifeMap.put(entry.getKey(), curEntryLife + 1);
                }
            }

        } else {
            //如果不存在要插入的值

            if (cache.size() < maxCap) {
                cache.put(key, value);
                for (Map.Entry<Integer, Integer> entry : lifeMap.entrySet()) {
                    //所有目前存在的年龄加一
                    lifeMap.put(entry.getKey(), entry.getValue() + 1);
                }
                lifeMap.put(key, 1);
            } else {
                //找到年龄为5的remove，其他的加一，并将目前的放进去
                //for-each实现
//                Integer oldKey = 0;
//                for (Map.Entry<Integer,Integer> entry : lifeMap.entrySet()) {
//                    int curEntryLife = entry.getValue();
//                    if (curEntryLife == maxCap) {
//                        oldKey = entry.getKey();
//                        cache.remove(oldKey);
//                        lifeMap.put(5,2);
//                    } else {
//                        entry.setValue(curEntryLife + 1);
//                    }
//                }
                //迭代器实现
                Iterator<Map.Entry<Integer, Integer>> entrys = lifeMap.entrySet().iterator();
                Integer oldKey = 0;
                while(entrys.hasNext()) {
                    Map.Entry<Integer, Integer> entry = entrys.next();
                    int curEntryLife = entry.getValue();
                    if (curEntryLife == maxCap) {
                        oldKey = entry.getKey();
                        entrys.remove();
                        cache.remove(oldKey);
//                        lifeMap.put(5,2);
                    } else {
                        entry.setValue(curEntryLife + 1);
                    }
                }
                lifeMap.put(key, 1);

                //移除老Key加入新Key
                cache.remove(oldKey);
                cache.put(key, value);
            }
        }
    }
}
