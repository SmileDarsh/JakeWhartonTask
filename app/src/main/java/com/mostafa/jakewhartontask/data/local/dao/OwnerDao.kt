package com.mostafa.jakewhartontask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mostafa.jakewhartontask.data.model.Owner

/**
 * Created by µðšţãƒâ ™ on 10/14/2019.
 *  ->
 */
@Dao
interface OwnerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOwner(owner: Owner)
}