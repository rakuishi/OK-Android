package com.rakuishi.ok.view.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.rakuishi.ok.App;
import com.rakuishi.ok.di.FragmentComponent;
import com.rakuishi.ok.di.FragmentModule;

public class BaseFragment extends Fragment {

    private FragmentComponent fragmentComponent;

    @NonNull
    public FragmentComponent getComponent() {
        if (fragmentComponent == null) {
            App app = (App) getContext().getApplicationContext();
            fragmentComponent = app.getComponent().fragmentComponent(new FragmentModule(this));
        }
        return fragmentComponent;
    }
}
