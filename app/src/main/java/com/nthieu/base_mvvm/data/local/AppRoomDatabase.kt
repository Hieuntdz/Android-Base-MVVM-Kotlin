package com.nthieu.base_mvvm.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nthieu.base_mvvm.data.model.LoginResponse
import com.nthieu.base_mvvm.data.model.TestDao
import com.nthieu.base_mvvm.utils.DefineRoomDataBase
import com.nthieu.base_mvvm.utils.Logger

@Database(
    entities = [TestDao::class],
    version = DefineRoomDataBase.DATABASE_VERSION,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun homeDao(): HomeDao

    companion object {
        private var database: AppRoomDatabase? = null
        fun getDataBase(context: Context): AppRoomDatabase {
            if (database != null) return database as AppRoomDatabase
            database = Room.databaseBuilder(
                context,
                AppRoomDatabase::class.java,
                DefineRoomDataBase.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Logger.debug("Database needFrameConfig on create")
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        Logger.debug("Database needFrameConfig open")
                    }
                })
                .build()
            return database as AppRoomDatabase
        }
    }


}