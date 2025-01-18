package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.model.Booking;
import cat.institutmarianao.sailing.ws.repository.BookingRepository;
import cat.institutmarianao.sailing.ws.service.BookingService;
import cat.institutmarianao.salinig.ws.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(@NotNull Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new NotFoundException("Booking not found"));
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return bookingRepository.existsById(id);
    }

    @Override
    public Booking save(@NotNull @Valid Booking booking) {
        return bookingRepository.saveAndFlush(booking);
    }

    @Override
    public Booking update(@NotNull @Valid Booking booking) {
        Booking dbBooking = getById(booking.getId());

        // Actualiza los campos necesarios
        // Ejemplo:
        if (booking.getSomeField() != null) {
            dbBooking.setSomeField(booking.getSomeField());
        }

        return bookingRepository.saveAndFlush(dbBooking);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        bookingRepository.deleteById(id);
    }

}