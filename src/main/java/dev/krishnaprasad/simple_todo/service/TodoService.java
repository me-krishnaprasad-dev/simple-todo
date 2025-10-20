package dev.krishnaprasad.simple_todo.service;

import dev.krishnaprasad.simple_todo.dto.TodoDTO;

import java.util.List;

/**
 * Service interface for managing ToDo items.
 *
 * <p>This interface defines the business operations that can be performed
 * on ToDo entities, abstracting the application logic away from the controller
 * and data access layers.</p>
 *
 * @author Krishnaprasad
 * @version 1.0
 * @since 2023-10-27
 */
public interface TodoService {

    /**
     * Retrieves all ToDo items available in the system.
     *
     * @return A list of {@link TodoDTO} objects. The list may be empty if no items exist.
     */
    List<TodoDTO> findAll();

    /**
     * Retrieves a specific ToDo item by its unique identifier.
     *
     * @param id The unique ID of the ToDo item.
     * @return The corresponding {@link TodoDTO} if found; otherwise, {@code null}.
     */
    TodoDTO findById(Long id);

    /**
     * Creates a new ToDo item.
     *
     * @param todoDTO The data of the ToDo item to create.
     * @return The created {@link TodoDTO}, including the generated ID.
     */
    TodoDTO save(TodoDTO todoDTO);

    /**
     * Updates an existing ToDo item identified by its ID.
     *
     * @param id The ID of the ToDo item to update.
     * @param todoDTO The new data to update the item with.
     * @return The updated {@link TodoDTO} if the item exists; otherwise, {@code null}.
     */
    TodoDTO update(Long id, TodoDTO todoDTO);

    /**
     * Deletes a ToDo item by its unique identifier.
     *
     * @param id The ID of the ToDo item to delete.
     * @return {@code true} if the deletion was successful; {@code false} if the item was not found.
     */
    boolean deleteById(Long id);
}
