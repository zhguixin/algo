package site.zhguixin.algo.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruCache {

    private Map<String, Entry> cacheMap;
    private LinkedList<Entry> cacheList;
    private int cap, count = 0;

    public LruCache(int cap) {
        this.cap = cap;
        cacheMap = new HashMap<>();
        cacheList = new LinkedList<>();
    }

    // 容量已满时, 移除链表最后一个元素, 删除map中对应的元素
    // 容量不满时, 插入到链表头部, 更新map中对应元素
    public void put(String key, String val) {
        count++;
        if (count >= cap) {
            Entry entry = cacheList.getLast();
            cacheMap.remove(entry.key);
            cacheList.removeLast();
            // cacheMap中移除最后一个
        }
        if (cacheMap.get(key) != null) {
            cacheList.remove(cacheMap.get(key));
            cacheMap.remove(key);
        }
        Entry entry = new Entry(key, val);
        cacheMap.put(key, entry);
        cacheList.addFirst(entry);
    }

    // key对应的元素不在map中, 返回null
    // key对应的元素在map中, 返回对应元素, 移除链表中的对应元素, 重新插入到链表头部
    public String get(String key) {
        if (cacheMap.get(key) != null) {
            cacheList.remove(cacheMap.get(key));
            cacheList.addFirst(cacheMap.get(key));
            return cacheMap.get(key).val;
        } else {
            return null;
        }
    }

    class Entry {
        public String key;
        public String val;

        public Entry(String key, String val) {
            this.key = key;
            this.val = val;
        }
    }
}
