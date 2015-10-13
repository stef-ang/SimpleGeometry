package com.stef_developer.simplegeometry;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RectangleFragment extends Fragment {

    private EditText etPanjang, etLebar;
    private FloatingActionButton fabCount;
    private LinearLayout llSolution;
    private TextView tvStep2, tvStep3;

    private View v;

    private double p, l, result;

    public RectangleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_rectangle, container, false);

        etPanjang = (EditText) v.findViewById(R.id.etPanjang);
        etLebar = (EditText) v.findViewById(R.id.etLebar);
        fabCount = (FloatingActionButton) v.findViewById(R.id.fabCount);
        llSolution = (LinearLayout) v.findViewById(R.id.llSolution);
        tvStep2 = (TextView) v.findViewById(R.id.tvStep2);
        tvStep3 = (TextView) v.findViewById(R.id.tvStep3);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fabCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etPanjang.getText().toString().isEmpty() &&
                        !etLebar.getText().toString().isEmpty()) {
                    p = Double.valueOf(etPanjang.getText().toString());
                    l = Double.valueOf(etLebar.getText().toString());

                    result = p * l;
                    llSolution.setVisibility(View.VISIBLE);
                    tvStep2.setText("L = " + p + " x " + l);
                    tvStep3.setText("L = " + result);
                } else {
                    Toast.makeText(getActivity(), "Pastikan semua isiian terisi.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}