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

public class Triangle2Fragment extends Fragment {

    private EditText etA, etB, etC;
    private FloatingActionButton fabCount;
    private LinearLayout llSolution;
    private TextView tvStep1a, tvStep1b, tvStep1c, tvStep3, tvStep4;
    private View line1a, line1b, v;

    private double a, b, c, s, result;

    public Triangle2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_triangle2, container, false);

        etA = (EditText) v.findViewById(R.id.etA);
        etB = (EditText) v.findViewById(R.id.etB);
        etC = (EditText) v.findViewById(R.id.etC);
        fabCount = (FloatingActionButton) v.findViewById(R.id.fabCount);
        llSolution = (LinearLayout) v.findViewById(R.id.llSolution);
        tvStep1a = (TextView) v.findViewById(R.id.tvStep1a);
        tvStep1b = (TextView) v.findViewById(R.id.tvStep1b);
        tvStep1c = (TextView) v.findViewById(R.id.tvStep1c);
        tvStep3 = (TextView) v.findViewById(R.id.tvStep3);
        tvStep4 = (TextView) v.findViewById(R.id.tvStep4);
        line1a = v.findViewById(R.id.line1a);
        line1b = v.findViewById(R.id.line1b);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fabCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etA.getText().toString().isEmpty() &&
                        !etB.getText().toString().isEmpty() &&
                        !etC.getText().toString().isEmpty()) {
                    a = Double.valueOf(etA.getText().toString());
                    b = Double.valueOf(etB.getText().toString());
                    c = Double.valueOf(etC.getText().toString());
                    s = (a+b+c)/2;

                    llSolution.setVisibility(View.VISIBLE);
                    tvStep1a.setText("a + b + c");
                    line1a.getLayoutParams().width = tvStep1a.getWidth();

                    tvStep1b.setText(a + " + " + b + " + " + c);
                    line1b.getLayoutParams().width = tvStep1b.getMeasuredWidth();

                    tvStep1c.setText("*s = " + s);

                    tvStep3.setText("L = \u221A("+s+".("+s+" - "+a+").("+s+" - "+b+").("+s+" - "+c+"))");

                    result = Math.sqrt(s*(s-a)*(s-b)*(s-c));
                    tvStep4.setText("L = " + result);
                } else {
                    Toast.makeText(getActivity(), "Pastikan semua isiian terisi.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
