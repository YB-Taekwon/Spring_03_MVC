package com.ian.itemservice.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    public void afterEach() {
        itemRepository.clear();
    }

    @Test
    void saveAndFindItem() {
        // given
        Item item = new Item("item", 10000, 10);

        // when
        Item saveItem = itemRepository.save(item);

        // then
        Item findItem = itemRepository.findById(saveItem.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        // when
        List<Item> items = itemRepository.findAll();

        // then
        assertThat(items).hasSize(2);
        assertThat(items).contains(item1, item2);
    }

    @Test
    void update() {
        // given
        Item beforeItem = new Item("beforeItem", 10000, 10);

        Item saveItem = itemRepository.save(beforeItem);
        Long id = saveItem.getId();

        // when
        Item afterItem = new Item("afterItem", 20000, 20);
        itemRepository.update(id, afterItem);

        // then
        Item updateItem = itemRepository.findById(id);

        assertThat(updateItem.getName()).isEqualTo(afterItem.getName());
        assertThat(updateItem.getPrice()).isEqualTo(afterItem.getPrice());
        assertThat(updateItem.getQuantity()).isEqualTo(afterItem.getQuantity());
    }
}