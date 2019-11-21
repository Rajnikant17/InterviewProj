package enrich.newproject.intervproj.DI;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import enrich.newproject.intervproj.ui.activities.MainActivity;

@Module
public abstract class ViewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory providerFactory(ViewModelProviderFactory providerFactory);
}
