package cat.institutmarianao.sailing.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cat.institutmarianao.sailing.ws.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {
}
