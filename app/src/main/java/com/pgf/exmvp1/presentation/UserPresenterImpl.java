package com.pgf.exmvp1.presentation;

import android.text.TextUtils;

import com.pgf.exmvp1.model.User;
import com.pgf.exmvp1.repository.UserRepository;
import com.pgf.exmvp1.view.UserView;

public class UserPresenterImpl implements UserPresenter {

    private UserView userView;
    private UserRepository userRepository;
    private User user;

    public UserPresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void resume() {

        loadUserDetails();
    }

    @Override
    public void pause() {

    }

    @Override
    public void loadUserDetails() {

        int userId = userView.getUserId();
        user = userRepository.getUser(userId);

        if (user == null) {

            userView.showUserNotFoundMessage();
        } else {

            userView.displayFirstName(user.getFirstName());
            userView.displayLastName(user.getLastName());
        }
    }

    @Override
    public void setView(UserView view) {
        this.userView = view;
    }

    @Override
    public void saveUser() {

        if (user != null) {

            if (TextUtils.isEmpty(userView.getFirstName()) || TextUtils.isEmpty(userView.getLastName())) {

                userView.showUserNameIsRequired();
            }
            else {

                user.setFirstName(userView.getFirstName());
                user.setLastName(userView.getLastName());
                userRepository.save(user);
                userView.showUserSavedMessage();
            }
        }
    }
}
