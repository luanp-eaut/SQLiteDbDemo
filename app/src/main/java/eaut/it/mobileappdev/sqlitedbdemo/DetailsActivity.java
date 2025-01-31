package eaut.it.mobileappdev.sqlitedbdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        DbHelper db = new DbHelper(this);
        //get users from database
        ArrayList<HashMap<String, String>> userList = db.GetUsers();

        // get listview
        ListView lv = findViewById(R.id.user_list);

        //create adapter
        ListAdapter adapter = new SimpleAdapter(DetailsActivity.this, userList, R.layout.list_row,new String[]{"name","designation","location"}, new int[]{R.id.name, R.id.designation, R.id.location});

        //assign adapter to listview
        lv.setAdapter(adapter);

        Button back = findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DetailsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}