package enrich.newproject.intervproj.DI;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import enrich.newproject.intervproj.ui.activities.MainActivity;

@Module
public abstract class ActivityBuilderModule {
     @PerActivity
    @ContributesAndroidInjector(modules = {MainActivityViewModelModule.class})
    public abstract MainActivity injectMainActivity();
}
