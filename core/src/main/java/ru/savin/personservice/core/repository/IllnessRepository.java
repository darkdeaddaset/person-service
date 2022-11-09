package ru.savin.personservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savin.personservice.core.model.Illness;

import java.util.List;
import java.util.Optional;

@Repository
public interface IllnessRepository extends JpaRepository<Illness, Long> {
    Optional<Illness> getIllnessesByHeaviness(String heaviness);
}
