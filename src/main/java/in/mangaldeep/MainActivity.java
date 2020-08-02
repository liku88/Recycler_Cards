package in.mangaldeep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<carditem> carditems;
    private Button buttonAdd, buttonDelete;
    private EditText editTextAdd, editTextDelete;



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carditems = new ArrayList<>();
        carditems.add( new carditem(R.drawable.node, "clicked by liku") );
        carditems.add( new carditem(R.drawable.oner, "clicked by liku1") );
        carditems.add( new carditem(R.drawable.twor, "clicked by liku2") );
        carditems.add( new carditem(R.drawable.threer, "clicked by liku3") );
        carditems.add( new carditem(R.drawable.fourr, "clicked by liku4") );
        carditems.add( new carditem(R.drawable.fiver, "clicked by liku5") );
        carditems.add( new carditem(R.drawable.sixr, "clicked by liku6") );

        recyclerView = findViewById(R.id.recyclerView);
        //performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        adapter = new ExampleAdapter(carditems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //find buttons
        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);
        //find edittexts
        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: make sure user is not allowed to submit empty form
                int position = Integer.parseInt(editTextAdd.getText().toString());
                addCard(position);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextDelete.getText().toString());
                deleteCard(position);
            }
        });






    }
    public void addCard(int position){
        carditems.add(position, new carditem(R.drawable.node, "new card added"));
        adapter.notifyItemInserted(position);
    }

    public void deleteCard(int position){
        carditems.remove(position);
        adapter.notifyItemRemoved(position);
    }
}