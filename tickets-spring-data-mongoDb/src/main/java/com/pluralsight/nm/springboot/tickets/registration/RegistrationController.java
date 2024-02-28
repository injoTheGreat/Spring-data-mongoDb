package com.pluralsight.nm.springboot.tickets.registration;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {
        String ticket = UUID.randomUUID().toString();

        return this.registrationRepository.save(new Registration(
                null, registration.productId(), ticket, registration.attendeeName()));
    }

    @GetMapping(path = "/{ticket}")
    public Registration get(@PathVariable("ticket") String ticket) {
        var registration = this.registrationRepository.findByTicketCode(ticket);
        if (registration == null) throw new NoSuchElementException("Registration with the ticket code " + ticket + " not found");

        return registration;
    }

    @GetMapping(path = "/all")
    public List<Registration> getAll() {
        return this.registrationRepository.findAll();
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        // Find valid registration by existing ticket code
        String ticketCode = registration.ticketCode();

        var existingRegistry = this.registrationRepository.findByTicketCode(ticketCode);
        if (existingRegistry == null) {
            throw new NoSuchElementException("Registration with ticket code " + ticketCode + " not found");
        }

        return this.registrationRepository.save(new Registration(existingRegistry.id(), existingRegistry.productId(),
                ticketCode, registration.attendeeName()));
    }

    @DeleteMapping(path = "/{ticket}")
    public void delete(@PathVariable("ticket") String ticket) {
        this.registrationRepository.deleteByTicketCode(ticket);
    }
}
