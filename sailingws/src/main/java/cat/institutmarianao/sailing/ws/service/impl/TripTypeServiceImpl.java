package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.model.TripType;
import cat.institutmarianao.sailing.ws.repository.TripTypeRepository;
import cat.institutmarianao.sailing.ws.service.TripTypeService;
import cat.institutmarianao.salinig.ws.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class TripTypeServiceImpl implements TripTypeService {

    @Autowired
    private TripTypeRepository tripTypeRepository;

    @Override
    public List<TripType> findAll() {
        return tripTypeRepository.findAll();
    }

    @Override
    public TripType getById(@NotNull Long id) {
        return tripTypeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return tripTypeRepository.existsById(id);
    }

    @Override
    public TripType save(@NotNull @Valid TripType tripType) {
        return tripTypeRepository.saveAndFlush(tripType);
    }

    @Override
    public TripType update(@NotNull @Valid TripType tripType) {
        TripType dbTripType = getById(tripType.getId());

        if (tripType.getTitle() != null) {
            dbTripType.setTitle(tripType.getTitle());
        }
        if (tripType.getCategory() != null) {
            dbTripType.setCategory(tripType.getCategory());
        }
        if (tripType.getDescription() != null) {
            dbTripType.setDescription(tripType.getDescription());
        }
        if (tripType.getPrice() > 0) {
            dbTripType.setPrice(tripType.getPrice());
        }
        if (tripType.getDepartures() != null) {
            dbTripType.setDepartures(tripType.getDepartures());
        }
        if (tripType.getDuration() > 0) {
            dbTripType.setDuration(tripType.getDuration());
        }
        if (tripType.getMaxPlaces() > 0) {
            dbTripType.setMaxPlaces(tripType.getMaxPlaces());
        }

        return tripTypeRepository.saveAndFlush(dbTripType);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        if (!existsById(id)) {
            throw new NotFoundException();
        }
        tripTypeRepository.deleteById(id);
    }

    @Override
    public List<TripType> findByCategory(@NotBlank String category) {
        return tripTypeRepository.findAll().stream()
                .filter(tripType -> tripType.getCategory().name().equalsIgnoreCase(category))
                .toList();
    }
}
