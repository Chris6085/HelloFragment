package mycompany.chrisit_chang.hellofragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements MyFirstFragment.SelectedButtonListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        MyFirstFragment MyFragment1Ref = new MyFirstFragment();
        MyFirstFragment2 MyFragment2Ref = new MyFirstFragment2();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.leftLinearLayout, MyFragment1Ref, "leftfragment");
        ft.add(R.id.rightLinearLayout, MyFragment2Ref, "rightfragment");
        // ft.addToBackStack(null);
        ft.commit();


        //addFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onButtonSelected(int id) throws NullPointerException{

        if(id == R.id.left_button1) {
            Fragment rightFragment = getSupportFragmentManager().findFragmentByTag("rightfragment");

            if (rightFragment.getView().findViewById(R.id.editText2) == null) {
                throw new NullPointerException();
            } else {
                //not null
                EditText editTextRef = (EditText)rightFragment.getView().findViewById(R.id.editText2);
                editTextRef.setText(R.string.edited_text);
            }



        } else {
//          if (id == R.id.left_button2)
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            UpdateFragment updateFragment = new UpdateFragment();
            ft.replace(R.id.rightLinearLayout, updateFragment);
            ft.addToBackStack(null);

            // Commit the transaction
            ft.commit();

        }




        //Fragment rightFragment = MyFirstFragment.this.getFragmentManager().findFragmentById(R.id.rightLinearLayout);
        //EditText editTextRef = (EditText) rightFragment.getView().findViewById(R.id.editText2);
        //editTextRef.setText("你已按下 Fragment1 按鍵");
    }

    void addFragment() {
        // Instantiate a new fragment.
        Fragment newFragment = new MyFirstFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.rightLinearLayout, newFragment, "Fragment1");
        //ft.add(R.id.activity_main, newFragment, "Fragment1");
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
