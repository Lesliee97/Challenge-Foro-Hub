package com.leslierodriguez.foroalura.model.repository;

import com.leslierodriguez.foroalura.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
