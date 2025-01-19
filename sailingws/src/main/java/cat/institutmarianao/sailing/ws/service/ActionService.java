package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Action;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ActionService {
    List<Action> findAll();
    
    Action getById(@NotNull Long id);
    
    Action save(@NotNull @Valid Action action);
    
    Action update(@NotNull @Valid Action action);
    
    void deleteById(@NotNull Long id);
    
    boolean existsById(@NotNull Long id);
}
