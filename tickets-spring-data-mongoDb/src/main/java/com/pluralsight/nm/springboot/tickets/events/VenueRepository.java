package com.pluralsight.nm.springboot.tickets.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Integer> {
//    public Venue findById(int index);
}
