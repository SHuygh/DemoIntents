package stijn.huygh.demointents;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private Button btnCall;
    private Button btnHomePage;
    private Button btnMap;
    private Button btnDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeBtnCall();

        makeBtnHomePage();

        makeBtnMap();

        makeBtnDetails();

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

        Uri uri = Uri.parse("voicemail:+32484295759");

        btnDetails.setOnClickListener(makeOnClickparser(uri));
    }
}
