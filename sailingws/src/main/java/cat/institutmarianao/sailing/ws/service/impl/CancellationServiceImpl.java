package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.sailing.ws.model.Cancellation;
import cat.institutmarianao.sailing.ws.repository.CancellationRepository;
import cat.institutmarianao.sailing.ws.service.CancellationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class CancellationServiceImpl implements CancellationService {

    private final CancellationRepository cancellationRepository;

    @Autowired
    public CancellationServiceImpl(CancellationRepository cancellationRepository) {
        this.cancellationRepository = cancellationRepository;
    }

    @Override
    public List<Cancellation> findAll() {
        return cancellationRepository.findAll();
    }

    @Override
    public Cancellation getById(@NotNull Long id) {
        return cancellationRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Cancellation not found with ID: " + id));
    }

    @Override
    public Cancellation save(@NotNull @Valid Cancellation cancellation) {
        return cancellationRepository.save(cancellation);
    }

    @Override
    public Cancellation update(@NotNull @Valid Cancellation cancellation) {
        if (!cancellationRepository.existsById(cancellation.getId())) {
            throw new IllegalArgumentException("Cancellation not found with ID: " + cancellation.getId());
        }
        return cancellationRepository.save(cancellation);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        if (!cancellationRepository.existsById(id)) {
            throw new IllegalArgumentException("Cancellation not found with ID: " + id);
        }
        cancellationRepository.deleteById(id);
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return cancellationRepository.existsById(id);
    }
}
