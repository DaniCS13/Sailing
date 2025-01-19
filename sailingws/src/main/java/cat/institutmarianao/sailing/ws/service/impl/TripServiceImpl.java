package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.model.Trip;
import cat.institutmarianao.sailing.ws.repository.TripRepository;
import cat.institutmarianao.sailing.ws.service.TripService;
import cat.institutmarianao.salinig.ws.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Trip getById(@NotNull Long id) {
        return tripRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return tripRepository.existsById(id);
    }

    @Override
    public Trip save(@NotNull @Valid Trip trip) {
        return tripRepository.saveAndFlush(trip);
    }

    @Override
    public Trip update(@NotNull @Valid Trip trip) {
        Trip dbTrip = getById(trip.getId());

        if (trip.getPlaces() > 0) {
            dbTrip.setPlaces(trip.getPlaces());
        }

        if (trip.getDeparture() != null) {
            dbTrip.setDeparture(trip.getDeparture());
        }

        if (trip.getTracking() != null) {
            dbTrip.setTracking(trip.getTracking());
        }

        return tripRepository.saveAndFlush(dbTrip);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        if (!existsById(id)) {
            throw new NotFoundException();
        }
        tripRepository.deleteById(id);
    }

    @Override
    public List<Trip> findByClientUsername(@NotNull String username) {
        return tripRepository.findAll().stream()
                .filter(trip -> trip.getClient().getUsername().equals(username))
                .toList();
    }
}
