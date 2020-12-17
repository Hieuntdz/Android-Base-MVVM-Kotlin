package com.nthieu.base_mvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nthieu.base_mvvm.utils.Define

@Entity(tableName = "TestDao")
class TestDao {
    @PrimaryKey
    @ColumnInfo(name = "test_id")
    var id: Int? = null
}