package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PizzaMenuFragment extends Fragment {


    ArrayAdapter<String> itemsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, Pizza.pizzaMenu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pizza_menu, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ListView lvItems = (ListView) view.findViewById(R.id.lvItems);
        lvItems.setAdapter(itemsAdapter);

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onPizzaItemSelected(position);
            }
        });
    }

    private OnItemSelectedListener listener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener){
            this.listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement PizzaMenuFragment.OnItemSelectedListener");
        }
    }

    public interface OnItemSelectedListener {
        void onPizzaItemSelected(int position);
    }

}
