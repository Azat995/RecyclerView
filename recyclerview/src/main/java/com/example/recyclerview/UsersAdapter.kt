package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recyclerview.databinding.ItemAnimalBinding
import com.example.recyclerview.databinding.ItemUserBinding

class UsersAdapter(
//    private val onAnimalClicked: (animal: Creature.Animal) -> Unit,
//    private val onUserClicked: (user: Creature.User) -> Unit,
    private val listener: Listener
) : ListAdapter<Creature, RecyclerView.ViewHolder>(Creature.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (Creature.Companion.Type.getByValue(viewType)) {
            Creature.Companion.Type.USER -> {
                UserVH(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }

            Creature.Companion.Type.ANIMAL -> {
                AnimalVH(ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserVH -> holder.bind(getItem(position) as Creature.User)
            is AnimalVH -> holder.bind(getItem(position) as Creature.Animal)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.value
    }

    inner class UserVH(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Creature.User) = with(binding) {
            nameTextView.text = user.name
            surnameTextView.text = user.surname
            avatarImageView.load(user.avatar)

            avatarImageView.setOnClickListener {
                listener.userClicked(user)
//                onUserClicked.invoke(user)
            }
        }
    }

    inner class AnimalVH(private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Creature.Animal) = with(binding) {
            nameTextView.text = animal.name
            animalImageView.load(animal.photo)

            animalImageView.setOnClickListener {
                listener.animalClicked(animal)
//                onAnimalClicked.invoke(animal)
            }
        }
    }

    interface Listener {
        fun userClicked(user: Creature.User)
        fun animalClicked(animal: Creature.Animal)
    }
}
