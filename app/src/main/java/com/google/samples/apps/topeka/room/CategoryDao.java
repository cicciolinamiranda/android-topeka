package com.google.samples.apps.topeka.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.google.samples.apps.topeka.model.Category;

import java.util.List;

@Dao
public interface CategoryDao {

    @Query("SELECT * FROM category")
    List<Category> getAll();

    @Insert
    void insertCategory(Category category);

    @Query("DELETE FROM category")
    void deleteAll();
}
