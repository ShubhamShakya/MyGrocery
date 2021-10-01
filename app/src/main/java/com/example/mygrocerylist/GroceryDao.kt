package com.example.mygrocerylist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import androidx.room.OnConflictStrategy

@Dao
interface GroceryDao {
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insert(item: GroceryItems)

    @Delete
    suspend fun delete(item:GroceryItems)

    @Query ("Select * from grocery_items")
    fun getAllGroceryItems(): LiveData<List<GroceryItems>>

}