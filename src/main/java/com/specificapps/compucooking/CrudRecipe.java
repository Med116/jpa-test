package com.specificapps.compucooking;

import com.specificapps.compucooking.entities.Author;
import com.specificapps.compucooking.entities.Ingredient;
import com.specificapps.compucooking.entities.Recipe;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by mark on 11/12/18.
 */
public class CrudRecipe {

    EntityManagerFactory emf;
    EntityManager em;

    public CrudRecipe(){
        emf = Persistence.createEntityManagerFactory("RecipeService");
        em = emf.createEntityManager();
    }


    public Recipe buildRecipe(String recipeName, String recipeDescription,
                              String authorName, List<String> ingredients){

    Recipe recipe = new Recipe();
        recipe.setTitle(recipeName);
        recipe.setDescription(recipeDescription);
        Author author = new Author();
        author.setFirstName(authorName);
        recipe.setRecipeAuthor(author);

        List<Ingredient> recipeIngredients = ingredients.stream().map(ing ->{
            Ingredient i = new Ingredient();
            i.setName(ing);
            return i;
            }).collect(Collectors.toList());
        recipe.setIngredientList(recipeIngredients);




        return recipe;


    }

    public Recipe buildRecipe(String recipeName, String recipeDescription,
                              Author author, List<String> ingredients){

        Recipe recipe = new Recipe();
        recipe.setTitle(recipeName);
        recipe.setDescription(recipeDescription);

        recipe.setRecipeAuthor(author);

        List<Ingredient> recipeIngredients = ingredients.stream().map(ing ->{
            Ingredient i = new Ingredient();
            i.setName(ing);
            return i;
        }).collect(Collectors.toList());
        recipe.setIngredientList(recipeIngredients);


        return recipe;


    }



    public void finish(){

        em.close();
        emf.close();
    }

    public void createRecipe( Recipe recipe){


         em.getTransaction().begin();
         em.persist(recipe);

         Author author = recipe.getRecipeAuthor();
         System.out.println("Recipes before merging author ");
         List<Recipe> recipes = author.getRecipeList();
        recipes.stream().forEach(r-> System.out.println(r.getTitle()));
         em.flush();


        author.setRecipeList(Arrays.asList(recipe));
        System.out.println("Recipes after setting them");
        List<Recipe> recipesAfter = author.getRecipeList();
        recipesAfter.stream().forEach(r-> System.out.println(r.getTitle()));
        em.persist(author);

        em.refresh(recipe);
        em.getTransaction().commit();







    }


    public void updateRecipeAuthor(Author author){
        em.getTransaction().begin();


        String queryStr = "SELECT r FROM Recipe r WHERE r.recipeAuthor.firstName = :firstName";

        TypedQuery<Recipe> query = em.createQuery(queryStr, Recipe.class);
        query.setParameter("firstName", "Mark");

        Recipe mashedPotatoes = query.getSingleResult();
        mashedPotatoes.setRecipeAuthor(author);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }

    public void updateRecipeIngredients(List<Ingredient> ingredientList){
        em.getTransaction().begin();


        String queryStr = "SELECT r FROM Recipe r WHERE r.title = :title";

        TypedQuery<Recipe> query = em.createQuery(queryStr, Recipe.class);
        query.setParameter("title", "Mashed Potatoes");

        Recipe mashedPotatoes = query.getSingleResult();
        mashedPotatoes.setIngredientList(ingredientList);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }










}
