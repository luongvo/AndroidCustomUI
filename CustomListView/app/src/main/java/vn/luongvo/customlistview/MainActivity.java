package vn.luongvo.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuongV
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> strings = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            strings.add("Example " + i);
        }

        ListView listView1 = (ListView) findViewById(R.id.lv_example1);
        ListView listView2 = (ListView) findViewById(R.id.lv_example2);
        ExampleAdapter adapter = new ExampleAdapter(this, R.layout.item_example, strings);
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter);
    }
}
