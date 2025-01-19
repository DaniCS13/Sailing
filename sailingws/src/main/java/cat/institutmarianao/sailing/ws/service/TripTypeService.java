package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.TripType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface TripTypeService {
    List<TripType> findAll();
    
    TripType getById(@NotNull Long id);
    
    TripType save(@NotNull @Valid TripType tripType);
    
    TripType update(@NotNull @Valid TripType tripType);
    
    void deleteById(@NotNull Long id);
    
    boolean existsById(@NotNull Long id);
    
    List<TripType> findByCategory(@NotBlank String category);
}
