package com.maslov.springinaction.repos;

import com.maslov.springinaction.models.UserTaco;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserTaco, Long> {

    UserTaco findByUsername(String name);
}
