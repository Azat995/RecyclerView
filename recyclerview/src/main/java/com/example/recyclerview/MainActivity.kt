package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UsersAdapter.Listener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val creatures = arrayListOf<Creature>()
        var id: Long = 1

        creatures.add(Creature.User(id, "Ashot", "Ashrafyan", "https://sm.ign.com/ign_nordic/cover/a/avatar-gen/avatar-generations_prsz.jpg"))
        creatures.add(
            Creature.User(
                ++id,
                "David",
                "Ashrafyan",
                "https://images.pexels.com/photos/1485894/pexels-photo-1485894.jpeg?cs=srgb&dl=pexels-mohamed-almari-1485894.jpg&fm=jpg"
            )
        )
        creatures.add(Creature.User(++id, "Narek", "Sargsyan", "https://img.freepik.com/free-psd/3d-illustration-human-avatar-profile_23-2150671142.jpg"))
        creatures.add(Creature.User(++id, "Arman", "Yan", "https://i1.sndcdn.com/artworks-000562107012-2674mm-t500x500.jpg"))
        creatures.add(Creature.User(++id, "A", "Yan", "https://marketplace.canva.com/EAFauoQSZtY/1/0/1600w/canva-brown-mascot-lion-free-logo-qJptouniZ0A.jpg"))
        creatures.add(Creature.User(++id, "B", "AYan", "https://logos-world.net/wp-content/uploads/2020/05/Huawei-Logo.jpg"))
        creatures.add(Creature.User(++id, "C", "CYan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAHXPluq6GtTRPDIHRv5kJPy86uFjp5sO7hg&usqp=CAU"))

        creatures.add(Creature.Animal(++id, "Tiger", "https://files.worldwildlife.org/wwfcmsprod/images/Tiger_resting_Bandhavgarh_National_Park_India/hero_small/6aofsvaglm_Medium_WW226365.jpg"))
        creatures.add(
            Creature.Animal(
                ++id,
                "Lion",
                "https://img.resized.co/breaking-news/eyJkYXRhIjoie1widXJsXCI6XCJodHRwczpcXFwvXFxcL2ltYWdlcy5icmVha2luZ25ld3MuaWVcXFwvcHJvZFxcXC9CTl8xMDIwNzg4XzEwMDAwXzY1MjFfMF8xMTY1NVxcXC9JRS1NQUlOXFxcL0ZFQVRVUkVcXFwvMjAyMFxcXC8wOFxcXC8xMFxcXC9ibi0xMDEzNjM0XFxcL2JuLTEwMTM2MzRfNmQzZTliOWZhMGJmNGFhNGI2ZWM5OTYwYTc4YWZjN2UuanBnXCIsXCJ3aWR0aFwiOjEyMDAsXCJoZWlnaHRcIjo2MjcsXCJkZWZhdWx0XCI6XCJodHRwczpcXFwvXFxcL3d3dy5icmVha2luZ25ld3MuaWVcXFwvaW1hZ2VzXFxcL25vLWltYWdlLnBuZ1wiLFwib3B0aW9uc1wiOltdfSIsImhhc2giOiI4YWQ4YWQ2OWM4MTg4OWJkNTE4M2MyZjc0YjdiMzcxZWUyNjgxMTg4In0=/world-lion-day-9-things-you-never-knew-about-these-iconic-big-cats.jpg"
            )
        )
        creatures.add(Creature.Animal(++id, "Penguin", "https://www.cabq.gov/artsculture/biopark/news/10-cool-facts-about-penguins/@@images/1a36b305-412d-405e-a38b-0947ce6709ba.jpeg"))


//        usersAdapter = UsersAdapter(onAnimalClicked = {
//
//        }, onUserClicked = {
//
//        })
        /** Մէ հոյակապ ձև 1 */
//        usersAdapter = UsersAdapter(::animalClicked, ::userClicked)

        /** Մէ հոյակապ ձև 2 */
//        usersAdapter = UsersAdapter(adapterListener)
        usersAdapter = UsersAdapter(this)

        binding.usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity).apply {
                stackFromEnd = true
            }
            adapter = usersAdapter.apply {
                submitList(creatures)
            }
        }

        binding.submitButton.setOnClickListener {
            creatures.add(
                Creature.User(
                    ++id,
                    "Artur : $id",
                    "Avagyan",
                    "https://st2.depositphotos.com/1104517/11967/v/950/depositphotos_119675554-stock-illustration-male-avatar-profile-picture-vector.jpg"
                )
            )
            usersAdapter.submitList(creatures) {
                usersAdapter.notifyItemInserted(creatures.lastIndex)
                binding.usersRecyclerView.smoothScrollToPosition(creatures.lastIndex)
            }
        }
    }


    private val adapterListener = object : UsersAdapter.Listener {
        override fun userClicked(user: Creature.User) {
            showToast("He is ${user.name}")
        }

        override fun animalClicked(animal: Creature.Animal) {
            showToast("It is ${animal.name}")
        }
    }


    override fun userClicked(user: Creature.User) {
        showToast("He is ${user.name}")
    }

    override fun animalClicked(animal: Creature.Animal) {
        showToast("It is ${animal.name}")
    }

    private fun showToast(message: Any?) {
        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show()
    }
}