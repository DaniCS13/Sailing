package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Trip;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TripService {

    List<Trip> findAll();

    Trip getById(@NotNull Long id);

    boolean existsById(@NotNull Long id);

    Trip save(@NotNull @Valid Trip trip);

    Trip update(@NotNull @Valid Trip trip);

    void deleteById(@NotNull Long id);

    List<Trip> findByClientUsername(@NotNull String username);
}
