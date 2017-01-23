package es.cice.friendsdynamiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ListView friendsLV;
    private EditText friendET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List <String> listaInicial=new ArrayList<String>();
        listaInicial.add("Juana");
        listaInicial.add("Luis");
        listaInicial.add("Pedro");
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                listaInicial);
        friendsLV =(ListView)findViewById(R.id.friendsLV);
        friendsLV.setAdapter(adapter);
        friendET=(EditText)findViewById(R.id.newNameET);

    }
    public void addFriend(View v){
        String newFriend=friendET.getText().toString();
        adapter.add(newFriend);
        //para hacer que la lista cambie
        adapter.notifyDataSetChanged();
        friendET.setText("");
    }
}
