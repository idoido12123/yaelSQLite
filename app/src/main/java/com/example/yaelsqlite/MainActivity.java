package com.example.yaelsqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name, id, age,subject,grade;
    String stName,stId,stAge,stSubject,stGrade;
    SQLiteDatabase db;
    HelperDB hlp;
    Intent t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();

        name = (EditText) findViewById(R.id.editText);
        id = (EditText) findViewById(R.id.editText2);
        age = (EditText) findViewById(R.id.editText3);
        subject = (EditText) findViewById(R.id.editText4);
        grade = (EditText) findViewById(R.id.editText5);
    }
    public void data1(View view) {
        stId = id.getText().toString();
        stName= name.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(personInfo.STUDENT_ID, stId);
        cv.put(personInfo.STUDENT_NAME, stName);
        db = hlp.getWritableDatabase();
        db.insert(personInfo.TABLE_PERSONINFO,null, cv);
        db.close();
    }
    public void data2 (View view) {
        ContentValues cv = new ContentValues();
        stAge= age.getText().toString();
        stSubject= subject.getText().toString();
        stGrade= grade.getText().toString();
        cv.put(grades.AGE, stAge);
        cv.put(grades.SUBJECT, stSubject);
        cv.put(grades.GRADE, stGrade);
        db = hlp.getWritableDatabase();
        db.insert(grades.TABLE_GRADES,null, cv);
        db.close();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("tables")){
            t = new Intent(this, Main2Activity.class);
            startActivity(t);
        }
        if (st.equals("credits"))
            Toast.makeText(this, "this app was created by ido Cohen", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

}
