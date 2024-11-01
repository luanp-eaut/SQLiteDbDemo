package eaut.it.mobileappdev.sqlitedbdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name, loc, desig;
    Button saveBtn, detailBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.txtName);
        loc = findViewById(R.id.txtLocation);
        desig = findViewById(R.id.txtDesignation);
        saveBtn = findViewById(R.id.btnSave);
        detailBtn = findViewById(R.id.btnDetail);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString()+"\n";
                String location = loc.getText().toString();
                String designation = desig.getText().toString();
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                dbHelper.insertUserDetails(username,location,designation);
                openDetails();
                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails();
            }
        });
    }

    private void openDetails(){
        intent = new Intent(this,DetailsActivity.class);
        startActivity(intent);
    }
}