package com.study.scheduler.repository;

import com.study.scheduler.entity.Todo;
import com.study.scheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {


    Optional<User> findUserByUsername(String username);

    default User findUserByUsernameOrElseThrow(String username) {
        return findUserByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Does not exist username = " + username
                )
        );
    }

}
