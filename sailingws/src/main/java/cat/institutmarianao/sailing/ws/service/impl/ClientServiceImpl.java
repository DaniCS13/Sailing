package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.sailing.ws.model.Client;
import cat.institutmarianao.sailing.ws.repository.ClientRepository;
import cat.institutmarianao.sailing.ws.service.ClientService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        // Devuelve todos los clientes desde la base de datos
        return clientRepository.findAll();
    }

    @Override
    public Client getByUsername(@NotBlank String username) {
        // Busca un cliente por su nombre de usuario (username)
        return clientRepository.findById(username)
            .orElseThrow(() -> new RuntimeException("Client not found with username: " + username));
    }

    @Override
    public Client save(@NotNull @Valid Client client) {
        // Guarda un cliente en la base de datos
        return clientRepository.save(client);
    }

    @Override
    public Client update(@NotNull @Valid Client client) {
        // Verifica si el cliente existe antes de actualizarlo
        if (!clientRepository.existsById(client.getUsername())) {
            throw new RuntimeException("Client not found with username: " + client.getUsername());
        }
        return clientRepository.save(client);
    }

    @Override
    public void deleteByUsername(@NotBlank String username) {
        // Elimina un cliente por su nombre de usuario
        clientRepository.deleteById(username);
    }

    @Override
    public boolean existsByUsername(@NotBlank String username) {
        // Verifica si existe un cliente por su nombre de usuario
        return clientRepository.existsById(username);
    }
}
