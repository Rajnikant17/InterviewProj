package enrich.newproject.intervproj.utils;

import enrich.newproject.intervproj.model.ModelData;

public interface Listener {
    public void onStartProgress();
    public void onSuccess(ModelData modelData);
    public void onError(String s);
    public void noInternetConnection(String s);
    public void noDataFound(String s);
}
