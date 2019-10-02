package io.github.abhishekbhartiprojects.onboarding.data.room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @NonNull
    @PrimaryKey(autoGenerate = true)
    var id: String,
    @NonNull
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "age")
    var age: Int
)


