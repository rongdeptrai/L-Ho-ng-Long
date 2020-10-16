package com.example.baikiemtra1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[]={"How Long","Soo far","Crying Over You","Leave me alone"};
    String mDescrip[]={" Singer : Lê Hoàng Long","Singer : JayTee","Singer : Master D","Singer : Mr A"};
    int image[]={R.drawable.avata,R.drawable.ic_user,R.drawable.ic_user,R.drawable.ic_user};
    BottomNavigationView bottomNavigationView;
    Button bt;
    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.listView);
        bt=findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.pr:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                        case R.id.fr:
                            return true;
                }
                return false;
            }
        });
        MyAdapter adapter =new MyAdapter(this ,mTitle,mDescrip,image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    TextView tv = (TextView)findViewById(R.id.tv) ;
                    tv.setCursorVisible(true);

                    tv.setText("Hoang Long");
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> implements Filterable {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImage[];
        MyAdapter(Context c,String title[],String descrip[],int image[]){
            super(c,R.layout.row,R.id.textView1,title);
            this.rTitle=title;
            this.rDescription=descrip;
            this.rImage=image;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row =layoutInflater.inflate(R.layout.row,parent,false);
            ImageView image=row.findViewById(R.id.image);
            TextView myTitle=row.findViewById(R.id.textView1);
            TextView myDescription=row.findViewById(R.id.textView2);
            image.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row  ;
        }

    }


}