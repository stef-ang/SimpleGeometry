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

public class CircleFragment extends Fragment {

    private EditText etRadius;
    private FloatingActionButton fabCount;
    private LinearLayout llSolution;
    private TextView tvStep2, tvStep3;

    private View v;

    private double r, result;

    public CircleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_circle, container, false);

        etRadius = (EditText) v.findViewById(R.id.etRadius);
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
                if(!etRadius.getText().toString().isEmpty()) {
                    r = Double.valueOf(etRadius.getText().toString());
                    result = Math.PI * r * r;

                    llSolution.setVisibility(View.VISIBLE);
                    tvStep2.setText("L = \u03C0 x " + r + " x " + r);
                    tvStep3.setText("L = " + result);
                } else {
                    Toast.makeText(getActivity(), "Pastikan semua isiian terisi.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
