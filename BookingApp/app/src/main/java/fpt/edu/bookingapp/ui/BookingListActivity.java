package fpt.edu.bookingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import fpt.edu.bookingapp.R;
import fpt.edu.bookingapp.adapter.PersonAdapter;
import fpt.edu.bookingapp.dao.PersonDao;
import fpt.edu.bookingapp.model.Person;

public class BookingListActivity extends AppCompatActivity {

    PersonDao dao;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);

        dao = new PersonDao(this);
        recyclerView = findViewById(R.id.bookinglist_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Person> list = dao.getAllPersons();
        PersonAdapter personAdapter = new PersonAdapter(list);
        recyclerView.setAdapter(personAdapter);
    }
}