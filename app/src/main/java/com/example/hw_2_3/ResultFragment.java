package com.example.hw_2_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    private TextView resultTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        resultTextView = view.findViewById(R.id.resultTextView);


        if (getArguments() != null) {
            int counterValue = getArguments().getInt("counterValue", 0);
            setResult(counterValue);
        }

        return view;
    }

    public void setResult(int result) {
        resultTextView.setText(String.valueOf(result));
    }
}
