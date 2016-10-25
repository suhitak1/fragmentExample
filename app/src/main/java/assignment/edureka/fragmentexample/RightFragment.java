package assignment.edureka.fragmentexample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.graphics.Color;

/**
 * Created by suhit_000 on 7/15/2016.
 */
public class RightFragment extends Fragment {
    private static final String ARG_COLOR = "color";

    public static RightFragment newInstance(int color) {
        RightFragment fragment = new RightFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    public RightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.right_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            int color = getArguments().getInt(ARG_COLOR);

            switch (color) {
                case Color.RED:
                    view.findViewById(R.id.colorPanel).setBackgroundColor(Color.RED);
                    break;
                case Color.GREEN:
                    view.findViewById(R.id.colorPanel).setBackgroundColor(Color.GREEN);
                    break;
                case Color.BLUE:
                    view.findViewById(R.id.colorPanel).setBackgroundColor(Color.BLUE);
                    break;
                case Color.BLACK:
                    view.findViewById(R.id.colorPanel).setBackgroundColor(Color.BLACK);
                    break;
                case Color.GRAY:
                    view.findViewById(R.id.colorPanel).setBackgroundColor(Color.GRAY);
            }
        }
    }

}
