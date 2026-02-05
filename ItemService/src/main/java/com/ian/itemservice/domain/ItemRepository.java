package com.ian.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 동시성 고려 X
    private static final Map<Long, Item> store = new HashMap<>(); // ConcurrentHashMap
    private static long sequence = 0L; // AtomicLong

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);

        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Item afterItem) {
        Item beforeItem = findById(id);

        beforeItem.setName(afterItem.getName());
        beforeItem.setPrice(afterItem.getPrice());
        beforeItem.setQuantity(afterItem.getQuantity());
    }

    public void delete(Long id) {
        store.remove(id);
    }

    public void clear() {
        store.clear();
    }
}
