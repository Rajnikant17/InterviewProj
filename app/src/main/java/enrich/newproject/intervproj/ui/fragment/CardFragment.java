package enrich.newproject.intervproj.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import enrich.newproject.intervproj.R;
import enrich.newproject.intervproj.databinding.CardfragmentLayoutBinding;

public class CardFragment extends Fragment
{
    public  String str_content;
    CardfragmentLayoutBinding cardfragmentLayoutBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        cardfragmentLayoutBinding= DataBindingUtil.inflate(inflater, R.layout.cardfragment_layout,container,false);
        cardfragmentLayoutBinding.setFragmentlayout(this);
        View view=cardfragmentLayoutBinding.getRoot();
        Bundle bundle=getArguments();
        str_content=bundle.getString("content");
        return view;
    }
}
