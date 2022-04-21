package edu.polytech.gotoslim.conseil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.Ilistener;
import edu.polytech.gotoslim.conseil.listCreation.Meal;
import edu.polytech.gotoslim.conseil.listCreation.MealAdapter;
import edu.polytech.gotoslim.conseil.listCreation.lists.FactoryList;
import edu.polytech.gotoslim.conseil.listCreation.lists.MealList;

public class MealListActivity extends AppCompatActivity implements Ilistener {
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        type = getIntent().getStringExtra("typeMeal");
        MealList meals = (new FactoryList()).createList(type);

        MealAdapter adapter = new MealAdapter(getApplicationContext(), meals);

        ListView list = findViewById(R.id.listViewMeal);

        list.setAdapter(adapter);

        adapter.addListener(this);
    }

    @Override
    public void onClick(Meal item){
        Intent intent = new Intent(getApplicationContext(), MealActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}
