package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.BookedPlace;
import cat.institutmarianao.sailing.ws.model.BookedPlaceCompositeId;
import jakarta.validation.constraints.NotNull;

public interface BookedPlaceService {

	List<BookedPlace> findAll();

	BookedPlace getById(@NotNull BookedPlaceCompositeId id);

	List<BookedPlace> findByTripTypeIdAndDateAndDeparture(@NotNull Long tripTypeId, @NotNull java.util.Date date,
			@NotNull java.util.Date departure);

	BookedPlace save(@NotNull BookedPlace bookedPlace);

	BookedPlace update(@NotNull BookedPlace bookedPlace);

	void deleteById(@NotNull BookedPlaceCompositeId id);

	boolean existsById(@NotNull BookedPlaceCompositeId id);
}
