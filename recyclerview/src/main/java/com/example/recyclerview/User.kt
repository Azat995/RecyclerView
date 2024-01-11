package com.example.recyclerview

import androidx.recyclerview.widget.DiffUtil

sealed class Creature {

    abstract val id: Long
    abstract val type: Type

    data class User(
        override val id: Long,
        val name: String,
        val surname: String,
        val avatar: String,
        override val type: Type = Type.USER
    ) : Creature()

    data class Animal(
        override val id: Long,
        val name: String,
        val photo: String,
        override val type: Type = Type.ANIMAL
    ) : Creature()

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Creature>() {
            override fun areItemsTheSame(oldItem: Creature, newItem: Creature): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Creature, newItem: Creature): Boolean = oldItem == newItem
        }

        enum class Type(val value: Int) {
            USER(1),
            ANIMAL(2);

            companion object {
                fun getByValue(value: Int): Type = values().find { it.value == value } ?: USER
            }
        }
    }
}

