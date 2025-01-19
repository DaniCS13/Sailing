package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.model.Rescheduling;
import cat.institutmarianao.sailing.ws.repository.ReschedulingRepository;
import cat.institutmarianao.sailing.ws.service.ReschedulingService;
import cat.institutmarianao.salinig.ws.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class ReschedulingServiceImpl implements ReschedulingService {

    @Autowired
    private ReschedulingRepository reschedulingRepository;

    @Override
    public List<Rescheduling> findAll() {
        return reschedulingRepository.findAll();
    }

    @Override
    public Rescheduling getById(@NotNull Long id) {
        return reschedulingRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return reschedulingRepository.existsById(id);
    }

    @Override
    public Rescheduling save(@NotNull @Valid Rescheduling rescheduling) {
        return reschedulingRepository.saveAndFlush(rescheduling);
    }

    @Override
    public Rescheduling update(@NotNull @Valid Rescheduling rescheduling) {
        Rescheduling dbRescheduling = getById(rescheduling.getId());

        if (rescheduling.getNewDate() != null) {
            dbRescheduling.setNewDate(rescheduling.getNewDate());
        }

        if (rescheduling.getNewDeparture() != null) {
            dbRescheduling.setNewDeparture(rescheduling.getNewDeparture());
        }

        return reschedulingRepository.saveAndFlush(dbRescheduling);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        if (!existsById(id)) {
            throw new NotFoundException();
        }
        reschedulingRepository.deleteById(id);
    }
}
