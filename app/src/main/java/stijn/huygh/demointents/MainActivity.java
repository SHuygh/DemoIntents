package stijn.huygh.demointents;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private Button btnCall;
    private Button btnHomePage;
    private Button btnMap;
    private Button btnDetails;

    private Spinner spNameslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeBtnCall();

        makeBtnHomePage();

        makeBtnMap();

        makeBtnDetails();

        makeSpNamesList();
    }

    private void makeSpNamesList() {
        spNameslist = findViewById(R.id.sp_nameslist);

        String[] nameslist ={"Jan", "Piet", "Joris", "Korneel", "Iemand zonder baard"};


        //adapter -> klasse die elementen uit lijst in layout steekt per rij voor bv; spinner, listview
        //arrayadapter enkel layouts met 1 textveld (1 lijn tekst per rij)

        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, nameslist);

        spNameslist.setAdapter(mArrayAdapter);
    }

    private void makeBtnMap() {
        btnMap = findViewById(R.id.btn_map);

        String adres = "rolwagenstraat 67 2018 Antwerpen";
        Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(adres));

        btnMap.setOnClickListener(makeOnClickparser(uri));
    }

    private void makeBtnHomePage() {
        btnHomePage = findViewById(R.id.btn_homepage);

        Uri uri = Uri.parse("http://google.com");

        btnHomePage.setOnClickListener(makeOnClickparser(uri));
    }

    private void makeBtnCall() {
        btnCall = findViewById(R.id.btn_call);

        Uri uri = Uri.parse("tel:+32484295759");

        btnCall.setOnClickListener(makeOnClickparser(uri));
    }

    @NonNull
    private View.OnClickListener makeOnClickparser(final Uri uri) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        };
    }

    private void makeBtnDetails() {
        btnDetails = findViewById(R.id.btn_details);

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String selectedName = (String) spNameslist.getSelectedItem();


                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("name", selectedName);

                startActivity(intent);

            }
        });
    }
}
