package bharat.com.stackoverflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.robertlevonyan.views.chip.Chip;
import com.robertlevonyan.views.chip.OnCloseClickListener;

import java.util.ArrayList;
import java.util.List;

public class UserInterestActivty extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interest_activty);

        listview = findViewById(R.id.listview);
        Chip chip = findViewById(R.id.chip);
        RecyclerView recycler = findViewById(R.id.recyclerchips);

       // Character arr[10] ={"Java","Python","Sql","Hacking","JQuery","C++","IOS"};
        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("Python");
        tags.add("SQL");
        tags.add("C++");
        tags.add("C#");


        final ArrayAdapter<String> tagadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, tags);
        listview.setAdapter(tagadapter);


        RecyclerView.Adapter<ChipAdapter> = RecyclerView.Adapter


        chip.setOnCloseClickListener(new OnCloseClickListener() {
            @Override
            public void onCloseClick(View v) {


            }
        });

    }
}
