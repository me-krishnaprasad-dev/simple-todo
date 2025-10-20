package dev.krishnaprasad.simple_todo.controller.impl;

import dev.krishnaprasad.simple_todo.controller.TodoController;
import dev.krishnaprasad.simple_todo.dto.TodoDTO;
import dev.krishnaprasad.simple_todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller Implementation for managing ToDo items.
 *
 * <p>The base path for all ToDo related operations is {@code /api/todos}.</p>
 *
 * @author Krishnaprasad
 * @version 1.0
 * @since 2023-10-27
 */
@RestController
@RequiredArgsConstructor
public class TodoControllerImpl implements TodoController {

    private final TodoService todoService;

    /**
     * Retrieves a list of all ToDo items available in the system.
     * This endpoint supports fetching all existing tasks.
     *
     * @return A {@link ResponseEntity} containing a list of {@link TodoDTO} objects if successful (HTTP 200 OK).
     * The list might be empty if no ToDo items are present.
     */
    @Override
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        return ResponseEntity.ok(todoService.findAll());
    }

    /**
     * Retrieves a specific ToDo item by its unique identifier.
     *
     * @param id The unique ID of the ToDo item to retrieve. This is passed as a path variable.
     * @return A {@link ResponseEntity} containing the {@link TodoDTO} object if found (HTTP 200 OK),
     * or an appropriate error status (e.g., HTTP 404 Not Found) if no ToDo item with the given ID exists.
     */
    @Override
    public ResponseEntity<TodoDTO> getTodoById(Long id) {
        return ResponseEntity.ok(todoService.findById(id));
    }

    /**
     * Creates a new ToDo item based on the provided data.
     *
     * @param todoDTO The {@link TodoDTO} object containing the details of the new ToDo item to be created.
     *                This data is expected in the request body.
     * @return A {@link ResponseEntity} containing the newly created {@link TodoDTO} object
     * and a status of HTTP 201 Created if successful. Returns HTTP 400 Bad Request
     * if the input data is invalid.
     */
    @Override
    public ResponseEntity<TodoDTO> createTodo(TodoDTO todoDTO) {
        return ResponseEntity.ok(todoService.save(todoDTO));
    }

    /**
     * Updates an existing ToDo item identified by its unique ID.
     *
     * @param id      The unique ID of the ToDo item to be updated. This is passed as a path variable.
     * @param todoDTO The {@link TodoDTO} object containing the updated details for the ToDo item.
     *                This data is expected in the request body.
     * @return A {@link ResponseEntity} containing the updated {@link TodoDTO} object if successful (HTTP 200 OK).
     * Returns HTTP 404 Not Found if no ToDo item with the given ID exists.
     */
    @Override
    public ResponseEntity<TodoDTO> updateTodo(Long id, TodoDTO todoDTO) {
        return ResponseEntity.ok(todoService.update(id, todoDTO));
    }

    /**
     * Deletes a specific ToDo item from the system based on its unique identifier.
     *
     * @param id The unique ID of the ToDo item to delete. This is passed as a path variable.
     * @return A {@link ResponseEntity} with no content and a status of HTTP 204 No Content
     * if the deletion is successful. Returns HTTP 404 Not Found if no ToDo item
     * with the given ID exists.
     */
    @Override
    public ResponseEntity<Boolean> deleteTodo(Long id) {
        return ResponseEntity.ok(todoService.deleteById(id));
    }
}
