package com.mx.opencontrol.test;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mx.opencontrol.collector.DeviceFingerPrintResponseListener.DeviceCollectorListener;
import com.mx.opencontrol.collector.Opencontrol;
import com.mx.opencontrol.test.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Opencontrol opencontrol = new Opencontrol("M775ED8CC","L36D37A08","pk-c26f42996104456f9c552673a446cf3f",false);
                opencontrol.setup(view.getContext(), new DeviceCollectorListener() {
                    @Override
                    public void onError(Object o) {
                        Log.e("OPENCONTROL_ERROR",o.toString());
                    }

                    @Override
                    public void onResponse(String sessionId,String response) {
                        binding.textviewFirst.setText(sessionId);
                        Log.i("OPENCONTROL",response);
                    }
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}