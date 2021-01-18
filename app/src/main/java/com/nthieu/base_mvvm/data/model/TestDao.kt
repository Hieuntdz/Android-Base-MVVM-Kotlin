package com.nthieu.base_mvvm.data.model

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

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