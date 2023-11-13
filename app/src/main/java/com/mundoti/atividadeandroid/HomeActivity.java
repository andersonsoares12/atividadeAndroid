package com.mundoti.atividadeandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView textViewWelcome;
    private EditText editTextNewName;
    private Button buttonAddName;
    private RecyclerView recyclerViewNames;
    private ArrayList<String> namesList;
    private NamesAdapter namesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inicializando componentes
        textViewWelcome = findViewById(R.id.textViewWelcome);
        editTextNewName = findViewById(R.id.editTextNewName);
        buttonAddName = findViewById(R.id.buttonAddName);
        recyclerViewNames = findViewById(R.id.recyclerViewNames);

        // Configurando RecyclerView
        namesList = new ArrayList<>();
        namesAdapter = new NamesAdapter(namesList);
        recyclerViewNames.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNames.setAdapter(namesAdapter);

        // Recebendo nome do usuário da MainActivity
        String userName = getIntent().getStringExtra("NAME");
        textViewWelcome.setText("Bem-vindo, " + userName);

        // Configurando o botão para adicionar nomes à lista
        buttonAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNameToList();
            }
        });
    }

    private void addNameToList() {
        String newName = editTextNewName.getText().toString().trim();
        if (!newName.isEmpty()) {
            namesList.add(newName);
            namesAdapter.notifyDataSetChanged();
            editTextNewName.setText("");
        }
    }
}
