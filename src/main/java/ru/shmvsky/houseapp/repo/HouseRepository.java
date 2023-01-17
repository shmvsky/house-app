package ru.shmvsky.houseapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shmvsky.houseapp.entity.House;

public interface HouseRepository extends JpaRepository<House, Long> {
}