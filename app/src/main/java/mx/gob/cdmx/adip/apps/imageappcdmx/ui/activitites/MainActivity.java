package mx.gob.cdmx.adip.apps.imageappcdmx.ui.activitites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import mx.gob.cdmx.adip.apps.imageappcdmx.R;

public class MainActivity extends AppCompatActivity {
//ESTOY EN EL MASTER DE LA APP
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        Intent segundaactividad= new Intent(this, TestActivity.class);
        startActivity(segundaactividad);

    }
}