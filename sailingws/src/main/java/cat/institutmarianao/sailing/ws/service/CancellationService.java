package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Cancellation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface CancellationService {

    /**
     * Retrieve all cancellations.
     *
     * @return a list of all cancellations.
     */
    List<Cancellation> findAll();

    /**
     * Retrieve a cancellation by its ID.
     *
     * @param id the ID of the cancellation.
     * @return the cancellation with the specified ID.
     */
    Cancellation getById(@NotNull Long id);

    /**
     * Save a new cancellation.
     *
     * @param cancellation the cancellation to be saved.
     * @return the saved cancellation.
     */
    Cancellation save(@NotNull @Valid Cancellation cancellation);

    /**
     * Update an existing cancellation.
     *
     * @param cancellation the cancellation to be updated.
     * @return the updated cancellation.
     */
    Cancellation update(@NotNull @Valid Cancellation cancellation);

    /**
     * Delete a cancellation by its ID.
     *
     * @param id the ID of the cancellation to be deleted.
     */
    void deleteById(@NotNull Long id);

    /**
     * Check if a cancellation exists by its ID.
     *
     * @param id the ID of the cancellation.
     * @return true if the cancellation exists, false otherwise.
     */
    boolean existsById(@NotNull Long id);
}
