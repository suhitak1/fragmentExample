package assignment.edureka.fragmentexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LeftFragment.OnColorChosenListener{

    ListView listView;
    ArrayAdapter<String> colorAdapter;
    String[] colorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeftFragment leftFragment = LeftFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.leftFragmentContainer,
                leftFragment).commit();

    }

    @Override
    public void onColorChosen(int color) {
        RightFragment rightFragment = RightFragment.newInstance(color);
        getSupportFragmentManager().beginTransaction().replace(R.id.rightFragmentContainer,
                rightFragment).commit();
    }
}

