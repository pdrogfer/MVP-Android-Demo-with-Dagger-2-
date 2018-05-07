package com.pgf.exmvp1.presentation;

import com.pgf.exmvp1.view.UserView;

public interface UserPresenter extends LifecyclePresenter {

    void loadUserDetails();
    void setView(UserView view);
    void saveUser();
}
