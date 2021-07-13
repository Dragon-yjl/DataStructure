package com.liu.dao;

import com.liu.model.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> selectAllCategory();

    Category selectCategoryById(Integer id);
}
