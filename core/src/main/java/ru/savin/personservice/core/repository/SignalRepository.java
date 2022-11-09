package ru.savin.personservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savin.personservice.core.model.Signal;

@Repository
public interface SignalRepository extends JpaRepository<Signal, Long> {
}
