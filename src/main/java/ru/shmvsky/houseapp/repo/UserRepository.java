package ru.shmvsky.houseapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shmvsky.houseapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}