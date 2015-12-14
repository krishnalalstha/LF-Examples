package com.lf.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lf.example.R;

/**
 * Created by Braindigit on 8/26/15.
 */
public class ViewFragment extends Fragment {
    TextView txtInfo;

    public static Fragment newInstance(String params) {
        ViewFragment bannerFragment = new ViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("params", params);
        bannerFragment.setArguments(bundle);
        return bannerFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        txtInfo = (TextView) view.findViewById(R.id.txtInfo);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Bundle mBundle = getArguments();
        String params = mBundle.getString("params");

        txtInfo.setText(params);
    }
}
