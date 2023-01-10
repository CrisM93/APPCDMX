package mx.gob.cdmx.adip.apps.imageappcdmx.ui.activitites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import mx.gob.cdmx.adip.apps.imageappcdmx.R;
import mx.gob.cdmx.adip.apps.imageappcdmx.model.Test;
import mx.gob.cdmx.adip.apps.imageappcdmx.ui.adapters.TestAdapterRecyclerView;

public class TestActivity extends AppCompatActivity {

    private RecyclerView rv;
    private TestAdapterRecyclerView adapter;
    private ArrayList<Test> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Toolbar mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        rv = findViewById(R.id.rv);

        data = new ArrayList<>();
        data.add(new Test("Primer 1", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Android_logo_2019_%28stacked%29.svg/1200px-Android_logo_2019_%28stacked%29.svg.png", "Descripción 1"));
        data.add(new Test("Primer 2", "https://media.kasperskydaily.com/wp-content/uploads/sites/87/2019/12/11132630/android-device-identifiers-featured.jpg", "Descripción 2"));
        data.add(new Test("Primer 3", "https://www.adslzone.net/app/uploads-adslzone.net/2019/12/android-malware-apps.jpg?x=480&y=375&quality=40", "Descripción 3"));
        data.add(new Test("Primer 4", "https://www.muycomputer.com/wp-content/uploads/2019/12/android-1000x600.jpg", "Descripción 4"));
        data.add(new Test("Primer 5", "", "Descripción 5"));
        data.add(new Test("Primer 6", "", "Descripción 6"));
        System.out.println("---------------------------"  + data);
        System.out.println("---------------------------"  + data.get(0));
        System.out.println("---------------------------"  + data.size());

        adapter = new TestAdapterRecyclerView(
                this,
                data,
                new TestAdapterRecyclerView.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, Test test) {
                        Toast.makeText(TestActivity.this, test.getTitulo(), Toast.LENGTH_SHORT).show();
                    }
                });
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}