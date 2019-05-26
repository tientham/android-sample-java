package com.tientham.androidsample.ui;

import android.app.Fragment;
import android.widget.Toast;

import com.tientham.androidsample.di.HasComponent;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public abstract class BaseFragment extends Fragment {

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
