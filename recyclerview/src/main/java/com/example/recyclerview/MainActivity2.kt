package com.example.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var usersAdapter: UsersAdapter2

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val users = arrayListOf<User>()
//
//        repeat(1) {
//            users.add(User(Calendar.getInstance().timeInMillis, "Ashot", "Ashrafyan", "https://sm.ign.com/ign_nordic/cover/a/avatar-gen/avatar-generations_prsz.jpg"))
//            users.add(
//                User(
//                    Calendar.getInstance().timeInMillis,
//                    "David",
//                    "Ashrafyan",
//                    "https://images.pexels.com/photos/1485894/pexels-photo-1485894.jpeg?cs=srgb&dl=pexels-mohamed-almari-1485894.jpg&fm=jpg"
//                )
//            )
//            users.add(User(Calendar.getInstance().timeInMillis, "Narek", "Sargsyan", "https://img.freepik.com/free-psd/3d-illustration-human-avatar-profile_23-2150671142.jpg"))
//        }

//        usersAdapter = UsersAdapter2()

        binding.usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity2)
//            adapter = usersAdapter.apply {
//                submitList2(users)
//            }
        }

        binding.submitButton.setOnClickListener {
//            usersAdapter.submitList2(users.shuffled())
        }
    }

}