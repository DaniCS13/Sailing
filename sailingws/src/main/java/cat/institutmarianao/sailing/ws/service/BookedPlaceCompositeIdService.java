package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.BookedPlaceCompositeId;
import jakarta.validation.constraints.NotNull;

public interface BookedPlaceCompositeIdService {

	List<BookedPlaceCompositeId> findAll();

	BookedPlaceCompositeId getById(@NotNull Long tripTypeId, @NotNull java.util.Date date,
			@NotNull java.util.Date departure);

	boolean existsById(@NotNull Long tripTypeId, @NotNull java.util.Date date, @NotNull java.util.Date departure);
}
