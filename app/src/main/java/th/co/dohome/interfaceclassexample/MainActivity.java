package th.co.dohome.interfaceclassexample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        re = findViewById(R.id.re);
        final MainAdapter mAdapter = new MainAdapter();
        final ArrayList<String> listItem = new ArrayList<>();
        listItem.add("Item1");
        listItem.add("Item2");
        listItem.add("Item3");
        listItem.add("Item4");
        mAdapter.setListItem(listItem);
        re.setLayoutManager(new LinearLayoutManager(this));
        re.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void OnItemClickListener(int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemClickDeleteListener(final int position) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Delete");
                alert.setMessage("Confirm Delete!!");
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listItem.remove(position);
                        mAdapter.notifyItemRemoved(position);
                        mAdapter.notifyItemRangeChanged(position, listItem.size());
                        mAdapter.setListItem(listItem);
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
            }
        });

    }
}
