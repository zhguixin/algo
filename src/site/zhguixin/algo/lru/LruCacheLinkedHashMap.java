package site.zhguixin.algo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

// LinkedHashMap的accessOrder为true, 可以按访问顺序把元素移动到前面
public class LruCacheLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private int cacheSize;

    public LruCacheLinkedHashMap(int cap) {
        super(16, 0.75f, true);
        cacheSize = cap;
    }

    // 覆写该方法, 大于cacheSize时, 移除最后一个节点
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() >= cacheSize;
    }

    public void putCache(K key, V val) {
        this.put(key, val);
    }

    public V getCache(K key) {
        return this.get(key);
    }
}
