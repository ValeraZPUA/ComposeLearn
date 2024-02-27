package com.example.composelearning.model

import android.util.Log
import com.github.javafaker.Faker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.util.Random

interface UsersService {

    fun getUsers(): StateFlow<List<User>>

    fun removeUser(user: User)

    companion object {
        fun get(): UsersService = UsersServiceImpl
    }

}

private object UsersServiceImpl : UsersService {

    private const val count = 100
    private val faker = Faker.instance(Random(0))
    private val images = mutableListOf(
        "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
        "https://www.kasandbox.org/programming-images/avatars/spunky-sam-green.png",
        "https://www.kasandbox.org/programming-images/avatars/purple-pi.png",
        "https://www.kasandbox.org/programming-images/avatars/purple-pi-teal.png",
        "https://www.kasandbox.org/programming-images/avatars/purple-pi-pink.png",
        "https://www.kasandbox.org/programming-images/avatars/primosaur-ultimate.png",
        "https://www.kasandbox.org/programming-images/avatars/primosaur-tree.png",
        "https://www.kasandbox.org/programming-images/avatars/primosaur-sapling.png",
        "https://www.kasandbox.org/programming-images/avatars/orange-juice-squid.png",
        "https://www.kasandbox.org/programming-images/avatars/old-spice-man.png"
    )

    private val usersMutableStateFlow = MutableStateFlow(createUserList())

    override fun getUsers(): StateFlow<List<User>> {
        return usersMutableStateFlow
    }

    override fun removeUser(user: User) {
        usersMutableStateFlow.update { oldUsers -> oldUsers - user }
    }

    fun createUserList() = List(100) { index ->
        val id = index + 1L
        User(
            id = id,
            photoUrl = images[index % images.size],
            name = faker.name().firstName(),
            status = faker.shakespeare().hamletQuote()
        )
    }


}