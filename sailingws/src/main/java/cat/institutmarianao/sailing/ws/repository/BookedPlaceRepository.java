package cat.institutmarianao.sailing.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.institutmarianao.sailing.ws.model.BookedPlace;
import cat.institutmarianao.sailing.ws.model.BookedPlaceCompositeId;

public interface BookedPlaceRepository extends JpaRepository<BookedPlace, BookedPlaceCompositeId> {

	@Override
	Optional<BookedPlace> findById(BookedPlaceCompositeId id);

	@Override
	boolean existsById(BookedPlaceCompositeId id);

	// Método de búsqueda usando la clave compuesta
	Optional<BookedPlace> findById_TripTypeIdAndId_DateAndId_Departure(Long tripTypeId, java.util.Date date,
			java.util.Date departure);
}
