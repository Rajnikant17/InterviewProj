package enrich.newproject.intervproj;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import enrich.newproject.intervproj.DI.DaggerAppComponent;

public class BaseApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
        // return null;
    }
}

