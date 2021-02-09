package com.todo.app.main.data.local

import com.todo.app.utils.helper.Constants
import com.todo.app.utils.helper.SharedPrefUtils
import io.reactivex.Completable

/**
 * This is the local data source class of the project. This class contains all the basic methods
 * needed for local purposes.
 * @author Mohd. Asfaq-E-Azam Rifat
 */
class AppLocalDataSource {

    /**
     * This method logs out the user and clears the saved preferences
     * */
    fun logOut(): Completable {
        return Completable.fromAction {
            if (SharedPrefUtils.contains(Constants.PreferenceKeys.ACCESS_TOKEN)) {
                SharedPrefUtils.delete(Constants.PreferenceKeys.ACCESS_TOKEN)
            }

            if (SharedPrefUtils.contains(Constants.PreferenceKeys.LOGGED_IN)) {
                SharedPrefUtils.delete(Constants.PreferenceKeys.LOGGED_IN)
            }
        }
    }
}