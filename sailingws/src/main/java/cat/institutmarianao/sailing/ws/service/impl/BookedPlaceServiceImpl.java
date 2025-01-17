package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.sailing.ws.model.BookedPlace;
import cat.institutmarianao.sailing.ws.model.BookedPlaceCompositeId;
import cat.institutmarianao.sailing.ws.repository.BookedPlaceRepository;
import cat.institutmarianao.sailing.ws.service.BookedPlaceService;
import cat.institutmarianao.salinig.ws.exception.NotFoundException;
import jakarta.validation.constraints.NotNull;

@Service
public class BookedPlaceServiceImpl implements BookedPlaceService {

	@Autowired
	private BookedPlaceRepository bookedPlaceRepository;

	@Override
	public List<BookedPlace> findAll() {
		return bookedPlaceRepository.findAll();
	}

	@Override
	public BookedPlace getById(@NotNull BookedPlaceCompositeId id) {
		return bookedPlaceRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@Override
	public List<BookedPlace> findByTripTypeIdAndDateAndDeparture(@NotNull Long tripTypeId, @NotNull java.util.Date date,
			@NotNull java.util.Date departure) {
		return bookedPlaceRepository.findById_TripTypeIdAndId_DateAndId_Departure(tripTypeId, date, departure).stream()
				.toList();
	}

	@Override
	public BookedPlace save(@NotNull BookedPlace bookedPlace) {
		return bookedPlaceRepository.saveAndFlush(bookedPlace);
	}

	@Override
	public BookedPlace update(@NotNull BookedPlace bookedPlace) {
		return bookedPlaceRepository.saveAndFlush(bookedPlace);
	}

	@Override
	public void deleteById(@NotNull BookedPlaceCompositeId id) {
		bookedPlaceRepository.deleteById(id);
	}

	@Override
	public boolean existsById(@NotNull BookedPlaceCompositeId id) {
		return bookedPlaceRepository.existsById(id);
	}
}
