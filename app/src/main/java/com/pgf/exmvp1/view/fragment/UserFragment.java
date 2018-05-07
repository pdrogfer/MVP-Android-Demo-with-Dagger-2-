package com.pgf.exmvp1.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pgf.exmvp1.MvpApplication;
import com.pgf.exmvp1.R;
import com.pgf.exmvp1.presentation.UserPresenter;
import com.pgf.exmvp1.view.UserView;

import javax.inject.Inject;

public class UserFragment extends Fragment implements View.OnClickListener, UserView {

    @Inject
    UserPresenter userPresenter;

    private static final String USER_ID = "USER_ID";
    private EditText userFirstName;
    private EditText userLastName;
    private Button btnSaveUser;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MvpApplication mvpApplicationContext = (MvpApplication) getActivity().getApplication();
        mvpApplicationContext.getAppComponent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);

        userFirstName = rootView.findViewById(R.id.et_user_first_name);
        userLastName = rootView.findViewById(R.id.et_user_last_name);
        btnSaveUser = rootView.findViewById(R.id.btn_save_user);
        btnSaveUser.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userPresenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        userPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();

        userPresenter.pause();
    }

    @Override
    public void onClick(View v) {

        userPresenter.saveUser();
    }

    @Override
    public int getUserId() {

        return getArguments() == null ? 0 : getArguments().getInt(USER_ID, 0);
    }

    @Override
    public void displayFirstName(String name) {

        userFirstName.setText(name);
    }

    @Override
    public void displayLastName(String name) {

        userLastName.setText(name);
    }

    @Override
    public void showUserNotFoundMessage() {

        Toast.makeText(getActivity(), "User not found", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSavedMessage() {

        Toast.makeText(getActivity(), "User saved", Toast.LENGTH_LONG).show();
    }

    @Override
    public String getFirstName() {
        return userFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return userLastName.getText().toString();
    }

    @Override
    public void showUserNameIsRequired() {

        Toast.makeText(getActivity(), "Both First and Last name are required", Toast.LENGTH_SHORT).show();
    }
}
