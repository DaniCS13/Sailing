package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.model.Admin;
import cat.institutmarianao.sailing.ws.repository.AdminRepository;
import cat.institutmarianao.sailing.ws.service.AdminService;
import cat.institutmarianao.salinig.ws.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getByUsername(@NotBlank String username) {
        return adminRepository.findById(username).orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean existsById(@NotBlank String username) {
        return adminRepository.existsById(username);
    }

    @Override
    public Admin save(@NotNull @Valid Admin admin) {
        return adminRepository.saveAndFlush(admin);
    }

    @Override
    public Admin update(@NotNull @Valid Admin admin) {
        Admin dbAdmin = getByUsername(admin.getUsername());

        if (admin.getPassword() != null) {
            dbAdmin.setPassword(admin.getPassword());
        }

        return adminRepository.saveAndFlush(dbAdmin);
    }

    @Override
    public void deleteByUsername(@NotBlank String username) {
        if (!existsById(username)) {
            throw new NotFoundException();
        }
        adminRepository.deleteById(username);
    }
}
