package enrich.newproject.intervproj.ui.adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import enrich.newproject.intervproj.model.Dataum;
import enrich.newproject.intervproj.ui.fragment.CardFragment;

/* By Using FragmentStatePagerAdapter it only stores the savedInstanceState of fragments, and destroys all the fragments when they lose focus.
 while FragmentPagerAdapter stores the whole fragment in memory, and could increase a memory overhead if a large amount of fragments are used in ViewPager.*/

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Dataum> contenlist;
    public ViewPagerAdapter(@NonNull FragmentManager fm, List<Dataum> contenlist) {
        super(fm);
        this.contenlist=contenlist;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        CardFragment cardFragment=new CardFragment();
        Bundle  bundle=new Bundle();
        bundle.putString("content",contenlist.get(position).getText());
        cardFragment.setArguments(bundle);
        return cardFragment;
    }

    @Override
    public int getCount() {
        return contenlist.size();
    }
}
