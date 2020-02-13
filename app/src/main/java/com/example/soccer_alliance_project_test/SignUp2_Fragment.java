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

import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp2_Fragment extends Fragment implements View.OnClickListener{


    public NavController navController;
    private Context context;

    ImageButton signup2_next_btn;

    TextInputEditText signup2_name_edit_txt,signup2_age_edit_txt,signup2_country_layout,signup2_gender_edit_text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(getActivity(),R.id.host_fragment);
        context = getActivity().getApplicationContext();

        signup2_next_btn = view.findViewById(R.id.signup2_next_btn);
        signup2_next_btn.setOnClickListener(this);

        signup2_name_edit_txt = view.findViewById(R.id.signup2_name_edit_txt);
        signup2_age_edit_txt = view.findViewById(R.id.signup2_age_edit_txt);
        signup2_country_layout = view.findViewById(R.id.signup2_country_layout);
        signup2_gender_edit_text = view.findViewById(R.id.signup2_gender_edit_text);

    }

    @Override
    public void onClick(View view) {
        if(view == signup2_next_btn){

            String name = signup2_name_edit_txt.getEditableText().toString().trim();
            String age = signup2_age_edit_txt.getEditableText().toString().trim();
            String gender = signup2_gender_edit_text.getEditableText().toString().trim();
            String country = signup2_country_layout.getEditableText().toString().trim();

            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("age", age);
            bundle.putString("gender", gender);
            bundle.putString("country", country);

            navController.navigate(R.id.signup_profile_Fragment);

        }
    }
}
