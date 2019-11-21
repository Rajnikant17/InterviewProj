package enrich.newproject.intervproj.DI;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import enrich.newproject.intervproj.viewModels.MainActivityViewModel;

@Module
public abstract class MainActivityViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    public  abstract ViewModel bindMainActivityViewModel(MainActivityViewModel mainActivityViewModel);
}
