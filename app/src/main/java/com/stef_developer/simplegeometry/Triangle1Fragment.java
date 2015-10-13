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

public class Triangle1Fragment extends Fragment {

    private EditText etAlas, etTinggi;
    private FloatingActionButton fabCount;
    private LinearLayout llSolution;
    private TextView tvStep1, tvStep2, tvStep3;
    private View line1, line2, v;

    private double a, t, result;

    public Triangle1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_triangle1, container, false);

        etAlas = (EditText) v.findViewById(R.id.etAlas);
        etTinggi = (EditText) v.findViewById(R.id.etTinggi);
        fabCount = (FloatingActionButton) v.findViewById(R.id.fabCount);
        llSolution = (LinearLayout) v.findViewById(R.id.llSolution);
        tvStep1 = (TextView) v.findViewById(R.id.tvStep1);
        tvStep2 = (TextView) v.findViewById(R.id.tvStep2);
        tvStep3 = (TextView) v.findViewById(R.id.tvStep3);
        line1 = v.findViewById(R.id.line1);
        line2 = v.findViewById(R.id.line2);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fabCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etAlas.getText().toString().isEmpty() &&
                        !etTinggi.getText().toString().isEmpty()) {
                    a = Double.valueOf(etAlas.getText().toString());
                    t = Double.valueOf(etTinggi.getText().toString());

                    result = a * t * 0.5;
                    llSolution.setVisibility(View.VISIBLE);
                    tvStep1.setText("alas x tinggi");
                    line1.getLayoutParams().width = tvStep1.getWidth();
                    line1.setVisibility(View.VISIBLE);

                    tvStep2.setText(a + " x " + t);
                    line2.getLayoutParams().width = tvStep2.getWidth();
                    line2.setVisibility(View.VISIBLE);

                    tvStep3.setText("L = " + result);
                } else {
                    Toast.makeText(getActivity(), "Pastikan semua isiian terisi.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
