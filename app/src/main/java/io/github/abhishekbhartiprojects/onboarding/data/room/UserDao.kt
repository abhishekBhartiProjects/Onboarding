package io.github.abhishekbhartiprojects.onboarding.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers():LiveData<ArrayList<User>>

    @Query("DELETE FROM user")
    fun deleteAll()
}