package com.example.hw_2_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {

    private TextView counterTextView;
    private int counterValue = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        counterTextView = view.findViewById(R.id.counterTextView);
        Button incrementButton = view.findViewById(R.id.incrementButton);
        Button decrementButton = view.findViewById(R.id.decrementButton);
        Button nextFragmentButton = view.findViewById(R.id.nextFragmentButton);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue++;
                updateCounter();
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue--;
                updateCounter();
            }
        });

        nextFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("counterValue", counterValue);


                ResultFragment resultFragment = new ResultFragment();
                resultFragment.setArguments(bundle);


                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, resultFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        updateCounter();

        return view;
    }

    private void updateCounter() {
        counterTextView.setText(String.valueOf(counterValue));
    }
}
