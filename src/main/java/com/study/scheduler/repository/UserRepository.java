package com.study.scheduler.repository;

import com.study.scheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    List<User> id(Long id);

    Optional<User> findByUserid(String userid);

    default User findByUserIdOrElseThrow(String userid){
        return findByUserid(userid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + userid));
    }

    String username(String username);
}
