package com.pgf.exmvp1.repository;

import com.pgf.exmvp1.model.User;

public interface UserRepository {

    User getUser(int id);
    void save(User user);

}
