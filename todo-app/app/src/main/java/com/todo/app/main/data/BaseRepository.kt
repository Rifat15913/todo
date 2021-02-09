package com.todo.app.main.data

import com.todo.app.main.data.local.AppLocalDataSource
import com.todo.app.main.data.remote.AppRemoteDataSource

/**
 * This is the repository class of the project. This class contains all the basic methods needed
 * for the project purposes.
 * @author Mohd. Asfaq-E-Azam Rifat
 */
class BaseRepository {
    private val mAppLocalDataSource = AppLocalDataSource()
    private val mAppRemoteDataSource = AppRemoteDataSource()

    companion object {
        private lateinit var sInstance: BaseRepository

        /**
         * This method returns an instance of the this class
         *
         * @return instance of the this class
         * */
        fun on(): BaseRepository {
            return sInstance
        }

        /**
         * This method initializes the class
         * */
        @Synchronized
        fun init() {
            synchronized(BaseRepository::class.java) {
                sInstance = BaseRepository()
            }
        }
    }
}
