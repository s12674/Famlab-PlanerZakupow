package com.famlab.mateusz.planer.ds.database;

/**
 * Created by Mateusz on 05.12.2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.famlab.mateusz.planer.R;
import com.famlab.mateusz.planer.ds.models.Product;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;



class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "planer_zakupow.db";
    private static final int DB_VERSION = 21;

    public Context context;

    DBHelper(@NonNull Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource cs) {

        try {
            TableUtils.createTable(cs, Product.class);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource cs, int oldVersion, int newVersion) {
    }


    public <T> T get(Class<T> className, long id) {
        T object = null;
        SQLiteDatabase db = getReadableDatabase();
        db.beginTransaction();
        try {
            Dao<T, Long> dao = getDao(className);
            dao.setObjectCache(false);
            object = dao.queryForId(id);
            dao.clearObjectCache();
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        return object;
    }

    public <T> List<T> get(Class<T> className, String fieldName, Object value) {
        List<T> object = null;
        try {
            Dao<T, String> dao = getDao(className);
            dao.setObjectCache(false);
            object = dao.queryForEq(fieldName, value);
            dao.clearObjectCache();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public <T> List<T> get(Class<T> className, HashMap<String, Object> where) {
        List<T> object = null;
        try {
            Dao<T, String> dao = getDao(className);
            dao.setObjectCache(false);
            object = dao.queryForFieldValues(where);
            dao.clearObjectCache();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }


    public <T> void assignEmptyForeignCollection(Class<T> className, T obj, String tableName) {
        try {
            Dao<T, ?> dao = getDao(className);
            dao.assignEmptyForeignCollection(obj, tableName);
            dao.clearObjectCache();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> int update(Class<T> className, T obj) {
        int status = 0;
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            Dao<T, ?> dao = getDao(className);
            dao.setObjectCache(false);
            status = dao.update(obj);

            dao.clearObjectCache();
            db.setTransactionSuccessful();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        return status;
    }

    public <T> int clear(Class<T> className) {
        int status = 0;
        try {
            Dao<T, ?> dao = getDao(className);
            status = dao.delete(dao.queryForAll());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public <T> int create(Class<T> className, T obj) {
        int status = 0;
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            Dao<T, ?> dao = getDao(className);
            dao.setObjectCache(false);
            dao.createIfNotExists(obj);
            dao.clearObjectCache();
            dao.closeLastIterator();
            db.setTransactionSuccessful();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        return status;
    }

    <T> List<T> getAll(Class<T> className) {
        List<T> list = null;
        try {
            Dao<T, ?> dao = getDao(className);
            list = dao.queryForAll();
            for (T obj : list) {
                dao.refresh(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    private int insertDBFromFile(SQLiteDatabase db, Context context, int resourceId) throws IOException {
        int result = 0;

        InputStream insertsStream = context.getResources().openRawResource(resourceId);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

        while (insertReader.ready()) {
            String insertStmt = insertReader.readLine();
            db.execSQL(insertStmt);
            result++;
        }
        insertReader.close();
        return result;
    }
}
