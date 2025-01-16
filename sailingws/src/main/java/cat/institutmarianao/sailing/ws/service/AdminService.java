package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Admin;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface AdminService {

	List<Admin> findAll();

	Admin getByUsername(@NotBlank String username);

	Admin save(@NotNull @Valid Admin admin);

	Admin update(@NotNull @Valid Admin admin);

	void deleteByUsername(@NotBlank String username);

	boolean existsById(@NotBlank String username);
}