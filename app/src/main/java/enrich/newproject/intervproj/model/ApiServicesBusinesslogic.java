package enrich.newproject.intervproj.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import javax.inject.Inject;
import javax.inject.Singleton;

import enrich.newproject.intervproj.utils.ApiServices;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class ApiServicesBusinesslogic {
    @Inject
    ApiServices apiServices;
    MutableLiveData<ModelData>  successOrErrorLivedata;
   public ModelData globalmodelDat=new ModelData();
    @Inject
    public ApiServicesBusinesslogic() {
    }

    public MutableLiveData<ModelData> FetchDataApi()
    {
       successOrErrorLivedata= new MutableLiveData<>();
        apiServices.fetchContentdata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ModelData>() {
                    @Override
                    public void onSuccess(ModelData modelData) {
                        modelData.setStatus("success");
                        successOrErrorLivedata.setValue(modelData);

                    }

                    @Override
                    public void onError(Throwable e) {
                        globalmodelDat.setStatus("error");
                        successOrErrorLivedata.setValue(globalmodelDat);
                        Log.d("error",e.getMessage());
                    }
                });
        return successOrErrorLivedata;
    }



}
