package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Rescheduling;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ReschedulingService {

    List<Rescheduling> findAll();

    Rescheduling getById(@NotNull Long id);

    boolean existsById(@NotNull Long id);

    Rescheduling save(@NotNull @Valid Rescheduling rescheduling);

    Rescheduling update(@NotNull @Valid Rescheduling rescheduling);

    void deleteById(@NotNull Long id);
}
