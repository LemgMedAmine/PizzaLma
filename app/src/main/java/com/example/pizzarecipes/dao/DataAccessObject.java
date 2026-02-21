package com.example.pizzarecipes.dao;

import java.util.List;

/**
 * Data Access Object (DAO) interface for basic CRUD operations.
 * This provides a generic interface for data persistence.
 * @param <T> The type of the object to persist.
 */
public interface DataAccessObject<T> {
    /**
     * Creates a new entry in the data store.
     * @param item The item to create.
     * @return The created item.
     */
    T create(T item);

    /**
     * Updates an existing entry in the data store.
     * @param item The item to update.
     * @return The updated item.
     */
    T update(T item);

    /**
     * Deletes an entry from the data store by its ID.
     * @param id The ID of the item to delete.
     * @return true if deletion was successful, false otherwise.
     */
    boolean delete(long id);

    /**
     * Finds an item by its ID.
     * @param id The ID of the item to find.
     * @return The found item, or null if not found.
     */
    T findById(long id);

    /**
     * Retrieves all items from the data store.
     * @return A list of all items.
     */
    List<T> findAll();
}
