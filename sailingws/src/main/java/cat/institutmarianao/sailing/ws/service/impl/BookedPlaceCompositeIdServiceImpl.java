package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.sailing.ws.model.BookedPlace;
import cat.institutmarianao.sailing.ws.model.BookedPlaceCompositeId;
import cat.institutmarianao.sailing.ws.repository.BookedPlaceRepository;
import cat.institutmarianao.sailing.ws.service.BookedPlaceCompositeIdService;
import jakarta.validation.constraints.NotNull;

@Service
public class BookedPlaceCompositeIdServiceImpl implements BookedPlaceCompositeIdService {

	@Autowired
	private BookedPlaceRepository bookedPlaceRepository;

	@Override
	public List<BookedPlaceCompositeId> findAll() {
		// Convertimos la lista de BookedPlace en una lista de BookedPlaceCompositeId
		return bookedPlaceRepository.findAll().stream().map(BookedPlace::getId) // 'getId' retorna la clave compuesta
																				// (BookedPlaceCompositeId)
				.collect(Collectors.toList());
	}

	@Override
	public BookedPlaceCompositeId getById(@NotNull Long tripTypeId, @NotNull java.util.Date date,
			@NotNull java.util.Date departure) {
		// Creamos el BookedPlaceCompositeId con los parámetros proporcionados
		BookedPlaceCompositeId id = new BookedPlaceCompositeId();
		id.setTripTypeId(tripTypeId);
		id.setDate(date);
		id.setDeparture(departure);

		// Usamos el repositorio de BookedPlace para buscar por la clave compuesta
		return bookedPlaceRepository.findById(id).map(BookedPlace::getId) // Devolvemos la clave compuesta
																			// (BookedPlaceCompositeId)
				.orElseThrow(() -> new NotFoundException("BookedPlace not found"));
	}

	@Override
	public boolean existsById(@NotNull Long tripTypeId, @NotNull java.util.Date date,
			@NotNull java.util.Date departure) {
		// Creamos el BookedPlaceCompositeId con los parámetros proporcionados
		BookedPlaceCompositeId id = new BookedPlaceCompositeId();
		id.setTripTypeId(tripTypeId);
		id.setDate(date);
		id.setDeparture(departure);

		// Usamos el repositorio de BookedPlace para verificar si existe la clave
		// compuesta
		return bookedPlaceRepository.existsById(id);
	}
}
