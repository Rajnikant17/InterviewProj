package enrich.newproject.intervproj.DI;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import enrich.newproject.intervproj.BaseApplication;

@Singleton
@Component(modules = {AndroidInjectionModule.class,ViewModelFactoryModule.class,ActivityBuilderModule.class,ApiCallModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

        @Component.Builder
        interface Builder
        {
                @BindsInstance
                Builder application(Application application);
        AppComponent build();
        }

}
