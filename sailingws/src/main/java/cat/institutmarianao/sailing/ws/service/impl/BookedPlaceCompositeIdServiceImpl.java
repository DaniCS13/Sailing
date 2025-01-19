package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.sailing.ws.model.BookedPlace;
import cat.institutmarianao.sailing.ws.model.BookedPlaceCompositeId;
import cat.institutmarianao.sailing.ws.repository.BookedPlaceRepository;
import cat.institutmarianao.sailing.ws.service.BookedPlaceCompositeIdService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class BookedPlaceCompositeIdServiceImpl implements BookedPlaceCompositeIdService {

    @Autowired
    private BookedPlaceRepository bookedPlaceRepository;

    @Override
    public List<BookedPlace> findAll() {
        return bookedPlaceRepository.findAll();
    }

    @Override
    public BookedPlace getById(@NotNull BookedPlaceCompositeId id) {  // Usar BookedPlaceCompositeId
        return bookedPlaceRepository.findById(id).orElseThrow(() -> new RuntimeException("BookedPlace not found"));
    }

    @Override
    public boolean existsById(@NotNull BookedPlaceCompositeId id) {  // Usar BookedPlaceCompositeId
        return bookedPlaceRepository.existsById(id);
    }

    @Override
    public BookedPlace save(@NotNull @Valid BookedPlace bookedPlace) {
        return bookedPlaceRepository.saveAndFlush(bookedPlace);
    }

    @Override
    public BookedPlace update(@NotNull @Valid BookedPlace bookedPlace) {
        BookedPlace dbBookedPlace = getById(bookedPlace.getId());  // Usar el id correcto

        // Actualiza los campos necesarios
        if (bookedPlace.getSomeField() != null) {
            dbBookedPlace.setSomeField(bookedPlace.getSomeField());
        }

        return bookedPlaceRepository.saveAndFlush(dbBookedPlace);
    }

    @Override
    public void deleteById(@NotNull BookedPlaceCompositeId id) {  // Usar BookedPlaceCompositeId
        bookedPlaceRepository.deleteById(id);
    }
}
