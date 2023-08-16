package com.cavsteek.CrudRestApi.Repo;

import com.cavsteek.CrudRestApi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
