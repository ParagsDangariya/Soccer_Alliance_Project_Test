package com.example.soccer_alliance_project_test;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;


public class forgot_pass1_Fragment extends Fragment implements View.OnClickListener {

    public NavController navController;
    private Context context;

    TextInputEditText fp1_email_edit_txt;
    ImageButton fp1_next_btn;
    FirebaseAuth fAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_pass1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(),R.id.host_fragment);
        context = getActivity().getApplicationContext();

        fp1_next_btn = view.findViewById(R.id.fp1_next_btn);
        fp1_next_btn.setOnClickListener(this);

        fp1_email_edit_txt = view.findViewById(R.id.fp1_email_edit_txt);

        fAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        if(view == fp1_next_btn){


            String email = fp1_email_edit_txt.getEditableText().toString().trim();
            fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getContext(), "Password rest link is sent to your Email", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), "Error! Reset link is not sent!"+e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

            navController.navigate(R.id.loginFragment);
        }
    }
}
