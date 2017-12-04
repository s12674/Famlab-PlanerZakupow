package com.famlab.mateusz.planer.ui.categories;

import com.famlab.mateusz.planer.ds.models.Categories;

/**
 * Created by Mateusz on 04.12.2017.
 */

public interface CategoriesContract {
    interface Presenter{
        void getCategories();
    }

    interface View{
        void showCategories(Categories categories);
    }
}
