package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface ClientService {

    List<Client> findAll();

    Client getByUsername(@NotBlank String username);

    Client save(@NotNull @Valid Client client);

    Client update(@NotNull @Valid Client client);

    void deleteByUsername(@NotBlank String username);

    boolean existsByUsername(@NotBlank String username);
}
