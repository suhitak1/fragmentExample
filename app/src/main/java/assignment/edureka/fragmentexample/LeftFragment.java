package assignment.edureka.fragmentexample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by suhit_000 on 7/15/2016.
 */
public class LeftFragment extends Fragment implements ListView.OnItemClickListener {

    private OnColorChosenListener mOnColorChosenListener;
    private ListView listView;
    private ArrayAdapter<String> colorAdapter;
    private String[] colorList;

    public static LeftFragment newInstance(){
        return new LeftFragment();
    }

    public LeftFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mOnColorChosenListener = (OnColorChosenListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.left_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.colorListView);
        populateColorList();
        colorAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, colorList);
        listView.setAdapter(colorAdapter);
        listView.setOnItemClickListener(this);
    }

    private void populateColorList(){
        colorList = new String[5];
        colorList[0] = "Red";
        colorList[1] = "Black";
        colorList[2] = "Green";
        colorList[3] = "Blue";
        colorList[4] = "Gray";
    }

    @Override
    public void onDestroy() {
        mOnColorChosenListener = null;
        super.onDestroy();
    }

    private void updateDisplay(int color)
    {
            if (mOnColorChosenListener != null)
                mOnColorChosenListener.onColorChosen(color);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                updateDisplay(Color.RED);
                break;
            case 1:
                updateDisplay(Color.BLACK);
                break;
            case 2:
                updateDisplay(Color.GREEN);
                break;
            case 3:
                updateDisplay(Color.BLUE);
                break;
            case 4:
                updateDisplay(Color.GRAY);
                break;
        }
    }

public interface OnColorChosenListener {
        void onColorChosen(int color);
    }
}