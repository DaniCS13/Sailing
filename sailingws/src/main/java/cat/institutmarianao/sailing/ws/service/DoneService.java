package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Done;
import jakarta.validation.constraints.NotNull;

public interface DoneService {

    List<Done> findAll();

    Done getById(@NotNull Long id);

    Done save(@NotNull Done done);

    Done update(@NotNull Done done);

    void deleteById(@NotNull Long id);

    boolean existsById(@NotNull Long id);
}
