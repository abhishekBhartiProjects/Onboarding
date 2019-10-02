package io.github.abhishekbhartiprojects.onboarding.data.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private lateinit var INSTANCE: UserDatabase

        fun getUserDatabase(context: Context): UserDatabase {
            if(INSTANCE == null){
                synchronized(UserDatabase::class.java){
                    if(INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database")
                            .addCallback(userDbCallbacks)
                            .build()
                    }
                }
            }

            return INSTANCE
        }

        private var userDbCallbacks = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(INSTANCE).execute()
            }
        }

        private class PopulateDbAsync internal constructor(db: UserDatabase): AsyncTask<UserDatabase, Void, Void?>(){
            var userDao: UserDao
            init {
                userDao = db.getUserDao()
            }
            override fun doInBackground(vararg db: UserDatabase?): Void? {
                userDao.deleteAll()

                return null
            }

        }
    }
}