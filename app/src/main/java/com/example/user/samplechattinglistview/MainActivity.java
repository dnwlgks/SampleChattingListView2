package com.example.user.samplechattinglistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    Button sendBtn;

    ChatListAdapter mAdabter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        editText=(EditText)findViewById(R.id.inputView);
        sendBtn=(Button)findViewById(R.id.sendBtn);

        mAdabter=new ChatListAdapter();
        listView.setAdapter(mAdabter);
        sendBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                String input=editText.getText().toString();
                mAdabter.add(input);
                editText.setText("");
                listView.smoothScrollToPosition(mAdabter.getCount());
            }

        });
        //리스트뷰 아이템을 클릭 했을 때 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedMessage=(String)mAdabter.getItem(position);
                Toast.makeText(MainActivity.this, "clikedMessage", Toast.LENGTH_SHORT).show();

                /*
                intent intent=new Intent(MainActivity.this,ChatActivity.class);
                intent.putExtra("coxldqkd dlfma",clickedMessage);
                startActivity(ChaActivity);
            */
            }
        });


    }
}
