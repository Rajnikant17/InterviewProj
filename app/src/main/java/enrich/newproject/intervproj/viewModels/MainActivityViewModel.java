package enrich.newproject.intervproj.viewModels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import enrich.newproject.intervproj.model.ApiServicesBusinesslogic;
import enrich.newproject.intervproj.model.ModelData;
import enrich.newproject.intervproj.ui.activities.MainActivity;
import enrich.newproject.intervproj.utils.Constants;
import enrich.newproject.intervproj.utils.Listener;

public class MainActivityViewModel extends ViewModel
{
    MutableLiveData<ModelData> mutableLiveData;
    @Inject
    ApiServicesBusinesslogic apiServicesBusinesslogic;
    public Listener listener;
    @Inject
    public MainActivityViewModel() {
    }

    public void fetchcardViewContent(MainActivity mainActivity)
    {
        listener.onStartProgress();
        if(Constants.isNetworkAvailable(mainActivity)) {
            mutableLiveData= apiServicesBusinesslogic.FetchDataApi();
            mutableLiveData.observe(mainActivity, new Observer<ModelData>() {
                @Override
                public void onChanged(ModelData modelData) {

                   if(modelData.getStatus().equals("success"))
                    {
                        listener.onSuccess(modelData);

                        if(modelData.getData() != null && modelData.getData().size() !=0) {
                            listener.onSuccess(modelData);
                        }
                        else
                        {
                            listener.noDataFound("Sorry No Data in List.");
                        }
                    }
                    else if(modelData.getStatus().equals("error"))
                   {
                        listener.onError("Something went wrong please try in some time.");
                   }
                }
            });
        }
        else
        {
            listener.noInternetConnection("Please check internet connection and restart app.");
        }
    }
}
