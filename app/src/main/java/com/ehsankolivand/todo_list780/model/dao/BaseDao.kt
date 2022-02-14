package com.ehsankolivand.todo_list780.model.dao

import androidx.room.*
/**
* all public CRUD queries defined and all Dao classes must inherit from this interface
* */


@Dao
internal interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data:T):Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dataList:List<T>)

    @Update
    suspend fun update(data: T)

    @Delete
    suspend fun delete(data: T)

}