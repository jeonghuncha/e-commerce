package jeonghuncha.practice.msa.userservice.jpa;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByUserId(String userId);
}
