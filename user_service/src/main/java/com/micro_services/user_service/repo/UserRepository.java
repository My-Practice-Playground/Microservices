package com.micro_services.user_service.repo;

import com.micro_services.user_service.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author: shan
 * Created: 2023-11-24 10.40
 */

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserById(String id);
    User findUserById(String id);
}
