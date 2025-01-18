package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.sailing.ws.model.Done;
import cat.institutmarianao.sailing.ws.repository.DoneRepository;
import cat.institutmarianao.sailing.ws.service.DoneService;
import jakarta.validation.constraints.NotNull;

@Service
public class DoneServiceImpl implements DoneService {

    @Autowired
    private DoneRepository doneRepository;

    @Override
    public List<Done> findAll() {
        // Devuelve todas las acciones de tipo 'DONE' desde la base de datos
        return doneRepository.findAll();
    }

    @Override
    public Done getById(@NotNull Long id) {
        // Busca una acción de tipo 'DONE' por su ID
        return doneRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Done action not found with id: " + id));
    }

    @Override
    public Done save(@NotNull Done done) {
        // Guarda una acción de tipo 'DONE' en la base de datos
        return doneRepository.save(done);
    }

    @Override
    public Done update(@NotNull Done done) {
        // Verifica si la acción 'DONE' existe antes de actualizarla
        if (!doneRepository.existsById(done.getId())) {
            throw new RuntimeException("Done action not found with id: " + done.getId());
        }
        return doneRepository.save(done);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        // Elimina una acción de tipo 'DONE' por su ID
        doneRepository.deleteById(id);
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        // Verifica si existe una acción de tipo 'DONE' por su ID
        return doneRepository.existsById(id);
    }
}
