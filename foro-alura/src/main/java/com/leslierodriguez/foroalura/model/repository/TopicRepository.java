package com.leslierodriguez.foroalura.model.repository;

import com.leslierodriguez.foroalura.model.Topic;
import com.leslierodriguez.foroalura.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
}
