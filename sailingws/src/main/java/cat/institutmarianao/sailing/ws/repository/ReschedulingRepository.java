package cat.institutmarianao.sailing.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cat.institutmarianao.sailing.ws.model.Rescheduling;

public interface ReschedulingRepository
		extends JpaRepository<Rescheduling, Long>, JpaSpecificationExecutor<Rescheduling> {
}