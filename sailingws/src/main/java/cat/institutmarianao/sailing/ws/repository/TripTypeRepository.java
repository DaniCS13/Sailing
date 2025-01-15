package cat.institutmarianao.sailing.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cat.institutmarianao.sailing.ws.model.TripType;

public interface TripTypeRepository extends JpaRepository<TripType, Long>, JpaSpecificationExecutor<TripType> {
}