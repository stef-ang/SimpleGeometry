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

public class TrapeziumFragment extends Fragment {

    private EditText etAtas, etBawah, etTinggi;
    private FloatingActionButton fabCount;
    private LinearLayout llSolution;
    private TextView tvStep1, tvStep2, tvStep3;
    private View line1, line2, v;

    private double a, b, t, result;

    public TrapeziumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_trapezium, container, false);

        etAtas = (EditText) v.findViewById(R.id.etAtas);
        etBawah = (EditText) v.findViewById(R.id.etBawah);
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
                if (!etAtas.getText().toString().isEmpty() &&
                        !etBawah.getText().toString().isEmpty() &&
                        !etTinggi.getText().toString().isEmpty()) {
                    a = Double.valueOf(etAtas.getText().toString());
                    b = Double.valueOf(etBawah.getText().toString());
                    t = Double.valueOf(etTinggi.getText().toString());

                    result = ((a + b) * t) / 2;
                    llSolution.setVisibility(View.VISIBLE);
                    tvStep1.setText("(alas + bawah) x tinggi");
                    line1.getLayoutParams().width = tvStep1.getWidth();

                    tvStep2.setText("(" + a + " + " + b + ") x " + t);
                    line2.getLayoutParams().width = tvStep2.getWidth();

                    tvStep3.setText("L = " + result);
                } else {
                    Toast.makeText(getActivity(), "Pastikan semua isiian terisi.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
