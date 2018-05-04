package com.pgf.exmvp1.repository;

import com.pgf.exmvp1.model.User;

public class InMemoryUserRepositoryImpl implements UserRepository {

    private User savedUser;

    @Override
    public User getUser(int id) {

        // Normally this would go to a DB/etc and fetch the user with an Id.
        // Here, for demo only, a fake implementation.

        if (savedUser == null) {

            savedUser = new User();
            savedUser.setId(id);
            savedUser.setFirstName("John");
            savedUser.setLastName("Malkovich");
        }

        return savedUser;
    }

    @Override
    public void save(User user) {

        if (savedUser == null) {

            savedUser = new User();
        }

        savedUser.setId(user.getId());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
    }
}
