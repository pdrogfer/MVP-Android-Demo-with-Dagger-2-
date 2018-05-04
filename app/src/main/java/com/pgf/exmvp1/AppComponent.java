package com.pgf.exmvp1;

import com.pgf.exmvp1.view.fragment.UserFragment;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {

    void inject(UserFragment target);
}
