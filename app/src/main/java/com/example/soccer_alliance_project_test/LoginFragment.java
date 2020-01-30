package com.example.soccer_alliance_project_test;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;


public class LoginFragment extends Fragment implements View.OnClickListener {


    public NavController navController;
    private Context context;
    MaterialButton guest_login_btn;
    TextView register_btn_on_login_page;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        navController = Navigation.findNavController(getActivity(),R.id.host_fragment);
        context = getActivity().getApplicationContext();

        register_btn_on_login_page = view.findViewById(R.id.register_btn_on_login_page);
        register_btn_on_login_page.setOnClickListener(this);

        guest_login_btn = view.findViewById(R.id.guest_login_btn);
        guest_login_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==register_btn_on_login_page){
            navController.navigate(R.id.signUp1_Fragment);
        }
        else if(view == guest_login_btn){
            Intent i = new Intent(context,Dashboard_Activity.class);
            startActivity(i);
        }
    }
}
