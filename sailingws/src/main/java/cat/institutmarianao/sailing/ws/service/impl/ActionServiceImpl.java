package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public List<Action> findAll() {
        return actionRepository.findAll();
    }

    @Override
    public Action getById(@NotNull Long id) {
        return actionRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return actionRepository.existsById(id);
    }

    @Override
    public Action save(@NotNull @Valid Action action) {
        return actionRepository.saveAndFlush(action);
    }

    @Override
    public Action update(@NotNull @Valid Action action) {
        Action dbAction = getById(action.getId());

        if (action.getComments() != null) {
            dbAction.setComments(action.getComments());
        }

        if (action.getDate() != null) {
            dbAction.setDate(action.getDate());
        }

        if (action.getTrip() != null) {
            dbAction.setTrip(action.getTrip());
        }

        if (action.getPerformer() != null) {
            dbAction.setPerformer(action.getPerformer());
        }

        return actionRepository.saveAndFlush(dbAction);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        if (!existsById(id)) {
            throw new NotFoundException();
        }
        actionRepository.deleteById(id);
    }
}
