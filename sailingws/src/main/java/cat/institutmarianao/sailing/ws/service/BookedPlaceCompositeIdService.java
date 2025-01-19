package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.BookedPlace;
import cat.institutmarianao.sailing.ws.model.BookedPlaceCompositeId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface BookedPlaceCompositeIdService {

    List<BookedPlace> findAll();

    BookedPlace getById(@NotNull BookedPlaceCompositeId id);

    boolean existsById(@NotNull BookedPlaceCompositeId id);

    BookedPlace save(@NotNull @Valid BookedPlace bookedPlace);

    BookedPlace update(@NotNull @Valid BookedPlace bookedPlace);

    void deleteById(@NotNull BookedPlaceCompositeId id);
}
