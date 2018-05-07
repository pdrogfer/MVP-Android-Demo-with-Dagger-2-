package com.pgf.exmvp1;

import com.pgf.exmvp1.presentation.UserPresenter;
import com.pgf.exmvp1.presentation.UserPresenterImpl;
import com.pgf.exmvp1.repository.InMemoryUserRepositoryImpl;
import com.pgf.exmvp1.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides @Singleton
    public UserRepository provideUserRepository() {

        return new InMemoryUserRepositoryImpl();
    }

    @Provides
    public UserPresenter provideUserPresenter(UserRepository userRepository) {

        return new UserPresenterImpl(userRepository);
    }
}
