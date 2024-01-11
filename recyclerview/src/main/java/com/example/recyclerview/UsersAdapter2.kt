//package com.example.recyclerview
//
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import coil.load
//import com.example.recyclerview.databinding.ItemUserBinding
//
//class UsersAdapter2 : RecyclerView.Adapter<UsersAdapter2.UserVH>() {
//
////    private var users = listOf<User>()
////
////    fun submitList2(users: List<User>) {
////        this.users = users
////        notifyDataSetChanged()
////    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
//        Log.d("+++", "onCreateViewHolder:")
//        return UserVH(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//    }
//
//    override fun onBindViewHolder(holder: UserVH, position: Int) {
//        Log.d("+++", "onBindViewHolder: position -> $position")
////        val user: User = users[position]
////        holder.binding.apply {
////            nameTextView.text = user.name
////            surnameTextView.text = user.surname
////            avatarImageView.load(user.avatar)
////        }
//    }
//
////    override fun getItemCount() = users.size
//
//    class UserVH(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)
//
//}
