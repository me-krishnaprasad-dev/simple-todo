package dev.krishnaprasad.simple_todo.controller;

import dev.krishnaprasad.simple_todo.dto.TodoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller interface for managing ToDo items.
 * This interface defines the contract for the RESTful API endpoints related to ToDo operations.
 * It leverages Spring Web annotations for request mapping and OpenAPI (Swagger) annotations
 * for comprehensive API documentation, ensuring that the API is well-described and easily consumable.
 *
 * <p>The base path for all ToDo related operations is {@code /api/todos}.</p>
 *
 * @author Krishnaprasad
 * @version 1.0
 * @since 2023-10-27
 */
@RestController
@RequestMapping("/api/todos")
@Tag(name = "ToDo API", description = "CRUD operations for managing ToDo items")
public interface TodoController {

    /**
     * Retrieves a list of all ToDo items available in the system.
     * This endpoint supports fetching all existing tasks.
     *
     * @return A {@link ResponseEntity} containing a list of {@link TodoDTO} objects if successful (HTTP 200 OK).
     *         The list might be empty if no ToDo items are present.
     */
    @GetMapping
    @Operation(summary = "Get all todos", description = "Retrieve a list of all ToDo items")
    @ApiResponse(responseCode = "200", description = "List of todos retrieved successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TodoDTO.class, type = "array")))
    ResponseEntity<List<TodoDTO>> getAllTodos();

    /**
     * Retrieves a specific ToDo item by its unique identifier.
     *
     * @param id The unique ID of the ToDo item to retrieve. This is passed as a path variable.
     * @return A {@link ResponseEntity} containing the {@link TodoDTO} object if found (HTTP 200 OK),
     *         or an appropriate error status (e.g., HTTP 404 Not Found) if no ToDo item with the given ID exists.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get a todo by ID", description = "Retrieve a specific ToDo item by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TodoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = @Content)})
    ResponseEntity<TodoDTO> getTodoById(
            @Parameter(description = "ID of the todo to retrieve", example = "1")
            @PathVariable Long id);

    /**
     * Creates a new ToDo item based on the provided data.
     *
     * @param todoDTO The {@link TodoDTO} object containing the details of the new ToDo item to be created.
     *                This data is expected in the request body.
     * @return A {@link ResponseEntity} containing the newly created {@link TodoDTO} object
     *         and a status of HTTP 201 Created if successful. Returns HTTP 400 Bad Request
     *         if the input data is invalid.
     */
    @PostMapping
    @Operation(summary = "Create a new todo", description = "Create and return the newly created ToDo item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Todo created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TodoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)})
    ResponseEntity<TodoDTO> createTodo(
            @RequestBody(
                    description = "JSON body with todo data",
                    required = true,
                    content = @Content(schema = @Schema(implementation = TodoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody TodoDTO todoDTO);

    /**
     * Updates an existing ToDo item identified by its unique ID.
     *
     * @param id The unique ID of the ToDo item to be updated. This is passed as a path variable.
     * @param todoDTO The {@link TodoDTO} object containing the updated details for the ToDo item.
     *                This data is expected in the request body.
     * @return A {@link ResponseEntity} containing the updated {@link TodoDTO} object if successful (HTTP 200 OK).
     *         Returns HTTP 404 Not Found if no ToDo item with the given ID exists.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing todo", description = "Update a ToDo item by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TodoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = @Content)})
    ResponseEntity<TodoDTO> updateTodo(
            @Parameter(description = "ID of the todo to update", example = "1")
            @PathVariable Long id,
            @RequestBody(
                    description = "Updated todo data",
                    required = true,
                    content = @Content(schema = @Schema(implementation = TodoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody TodoDTO todoDTO);

    /**
     * Deletes a specific ToDo item from the system based on its unique identifier.
     *
     * @param id The unique ID of the ToDo item to delete. This is passed as a path variable.
     * @return A {@link ResponseEntity} with no content and a status of HTTP 204 No Content
     *         if the deletion is successful. Returns HTTP 404 Not Found if no ToDo item
     *         with the given ID exists.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a todo", description = "Delete a specific ToDo item by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Todo deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = @Content)})
    ResponseEntity<Void> deleteTodo(
            @Parameter(description = "ID of the todo to delete", example = "1")
            @PathVariable Long id);
}