package mycompany.chrisit_chang.hellofragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFirstFragment extends Fragment {

    SelectedButtonListener mCallback;



    // Container Activity must implement this interface
    public interface SelectedButtonListener {
        public void onButtonSelected(int id);
    }

    public MyFirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {

                mCallback = (SelectedButtonListener) context;


        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement SelectedButtonListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Button button1;
        Button button2;
        View view;

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_first, container, false);

        button1 = (Button) view.findViewById(R.id.left_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCallback.onButtonSelected(R.id.left_button1);
            }
        });

        button2 = (Button) view.findViewById(R.id.left_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCallback.onButtonSelected(R.id.left_button2);
            }
        });



        return view;
    }
}
