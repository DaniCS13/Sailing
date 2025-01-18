package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.model.Action;
import cat.institutmarianao.sailing.ws.repository.ActionRepository;
import cat.institutmarianao.sailing.ws.service.ActionService;
import cat.institutmarianao.salinig.ws.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;

    public ActionServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public List<Action> findAll() {
        return actionRepository.findAll();
    }

    @Override
    public Action getById(@NotNull Long id) {
        return actionRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Action not found with ID: " + id));
    }

    @Override
    public Action save(@NotNull @Valid Action action) {
        return actionRepository.saveAndFlush(action);
    }

    @Override
    public Action update(@NotNull @Valid Action action) {
        Action dbAction = getById(action.getId());
        BeanUtils.copyProperties(action, dbAction, "id"); // Copy properties except ID
        return actionRepository.saveAndFlush(dbAction);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        if (!existsById(id)) {
            throw new NotFoundException("Action not found with ID: " + id);
        }
        actionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return actionRepository.existsById(id);
    }
}
