package ru.job4j.vkfriendskt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.job4j.vkfriendskt.activities.FriendsListActivity;

public class Test extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getApplicationContext(), FriendsListActivity.class);
        Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
    }
}
