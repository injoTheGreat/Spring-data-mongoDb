package com.pluralsight.nm.springboot.tickets.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
}
