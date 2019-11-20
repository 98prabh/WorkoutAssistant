package com.example.workoutassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Sprint_count extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprint_count);
        spinner = findViewById(R.id.spinner_sprint);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sprint_count, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getItemAtPosition(position).equals("Select Length"))
        {
            // do nothing
        }
        else
        {
            String text = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

            if(parent.getItemAtPosition(position).equals("60 meter"))
            {
                Intent i = new Intent(Sprint_count.this, LapCount.class);
                i.putExtra("Value","60");
                startActivity(i);
            }
            else if(parent.getItemAtPosition(position).equals("100 meter"))
            {
                Intent i = new Intent(Sprint_count.this, SprintActivity.class);
                i.putExtra("Value","100");
                startActivity(i);
            }
            else if(parent.getItemAtPosition(position).equals("200 meter"))
            {
                Intent i = new Intent(Sprint_count.this, SprintActivity.class);
                i.putExtra("Value","200");
                startActivity(i);
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
