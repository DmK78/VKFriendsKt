package ru.job4j.vkfriendskt.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.job4j.vkfriendskt.R

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(saved: Bundle?) {
        super.onCreate(saved)
        setContentView(R.layout.activity_main)
        val fm = supportFragmentManager
        if (fm.findFragmentById(R.id.fragment_container) == null) {
            fm.beginTransaction()
                .add(R.id.fragment_container, loadFrg()!!)
                .commit()
        }
    }

    abstract fun loadFrg(): Fragment?
}