package com.specificapps.compucooking.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mark on 11/10/18.
 */

@Entity
public class Recipe {


    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer recipeId;

    private String description;
    private String title;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Author recipeAuthor;

    @ManyToMany(cascade=CascadeType.PERSIST)
    private List<Ingredient> ingredientList;

    public Author getRecipeAuthor() {
        return recipeAuthor;
    }

    public void setRecipeAuthor(Author recipeAuthor) {
        this.recipeAuthor = recipeAuthor;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe that = (Recipe) o;

        if (recipeId != null ? !recipeId.equals(that.recipeId) : that.recipeId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = recipeId != null ? recipeId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


}
