package cat.institutmarianao.sailing.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cat.institutmarianao.sailing.ws.model.BookedPlaceCompositeId;

public interface BookedPlaceCompositeIdRepository
		extends JpaRepository<BookedPlaceCompositeId, String>, JpaSpecificationExecutor<BookedPlaceCompositeId> {
}
