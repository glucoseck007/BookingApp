package fpt.edu.bookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import fpt.edu.bookingapp.adapter.PersonAdapter;
import fpt.edu.bookingapp.dao.PersonDao;
import fpt.edu.bookingapp.model.Person;
import fpt.edu.bookingapp.ui.BookingListActivity;

public class MainActivity extends AppCompatActivity {

    PersonDao dao;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);



    }
}