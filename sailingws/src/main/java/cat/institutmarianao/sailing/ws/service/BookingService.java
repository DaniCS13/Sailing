package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Booking;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface BookingService {

    List<Booking> findAll();

    Booking getById(@NotNull Long id);

    Booking save(@NotNull @Valid Booking booking);

    Booking update(@NotNull @Valid Booking booking);

    void deleteById(@NotNull Long id);

    boolean existsById(@NotNull Long id);
}
