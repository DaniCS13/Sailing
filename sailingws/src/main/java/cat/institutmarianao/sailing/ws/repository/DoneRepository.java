package cat.institutmarianao.sailing.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cat.institutmarianao.sailing.ws.model.Done;

public interface DoneRepository extends JpaRepository<Done, Long>, JpaSpecificationExecutor<Done> {
}