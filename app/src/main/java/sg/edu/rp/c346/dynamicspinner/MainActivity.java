package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    // Define the variable for 3 UI element
    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;

    //Define the arrayList and array adapter
    ArrayList<String> alNumbers = new ArrayList<String>();
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 2 Binding the 3 UI element to 3 variable

        spn1 = (Spinner) findViewById(R.id.spinner1);
        spn2 = (Spinner) findViewById(R.id.spinner2);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);

        aaNumbers = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        spn2.setAdapter(aaNumbers);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear(); //If this is not clear, the ArrayList will keep adding
                if(pos==0) {
                    /*//option 1
                    alNumbers.add("2");
                    alNumbers.add("4");
                    alNumbers.add("6");*/
                    //option 2
                    String[] strNumbers = getResources().getStringArray(R.array.even_Numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));


                }
                else  {
                  /*  //option 1
                    alNumbers.add("1");
                    alNumbers.add("3");
                    alNumbers.add("5");*/
                    //option 2
                    String[] strNumbers = getResources().getStringArray(R.array.odd_Numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));

                }
                aaNumbers.notifyDataSetChanged();
            }
        });
        //when click on the 1st spinner, it will autochange my 2nd Spinner
        //Template code
        //This is for
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                if (pos == 0) {

                    //option 2
                    String[] strNumbers = getResources().getStringArray(R.array.even_Numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(2); //third item 2,4,6 starting from position 0


                } else {
                    //option 2
                    String[] strNumbers = getResources().getStringArray(R.array.odd_Numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(1); //2nd Item 1,3,5

                }
                aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                alNumbers.clear();
                aaNumbers.notifyDataSetChanged();

            }
        });



    }
}
