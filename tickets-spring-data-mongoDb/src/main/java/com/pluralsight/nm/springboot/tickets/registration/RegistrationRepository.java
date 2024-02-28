package com.pluralsight.nm.springboot.tickets.registration;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public interface RegistrationRepository extends MongoRepository<Registration, String> {

    Registration findByTicketCode(String ticketCode);
    void deleteByTicketCode(String ticketCode);

//    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
//
//    private final Map<String, Registration> registrationsByTicketCode = new ConcurrentHashMap<>();

//    public Registration create(@NotNull Registration registration) {
//        int id = ID_GENERATOR.incrementAndGet();
//        String ticket = UUID.randomUUID().toString();
//
//        Registration saved = new Registration(id, registration.productId(), ticket, registration.attendeeName());
//        this.registrationsByTicketCode.put(ticket, saved);
//
//        return saved;
//    }
//
//    public Registration findByTicketCode(String ticketCode) {
//        return registrationsByTicketCode.get(ticketCode);
//    }
//
//    public Map<String, Registration> getMap() {
//        return this.registrationsByTicketCode;
//    }
//
//    // update registration map with provided registration attendee name
//    public Registration update(@NotNull(message = "Registration properties are required") Registration registration) {
//        String ticketCode = registration.ticketCode();
//
//        var existingRegistry = findByTicketCode(ticketCode);
//        if (existingRegistry != null) {
//
//            var saved = new Registration(existingRegistry.id(), existingRegistry.productId(),
//                    existingRegistry.ticketCode(), registration.attendeeName());
//            registrationsByTicketCode.put(ticketCode, saved);
//
//            return saved;
//        } else {
//            throw new NoSuchElementException("Registration with ticket code " + ticketCode + " not found");
//        }
//    }
//
//    public void deleteByTicketCode(String ticketCode) {
//        if (findByTicketCode(ticketCode) != null) registrationsByTicketCode.remove(ticketCode);
//    }
}
