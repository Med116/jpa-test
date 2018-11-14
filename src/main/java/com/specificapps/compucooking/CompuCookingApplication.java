package com.specificapps.compucooking;

import com.specificapps.compucooking.entities.Author;
import com.specificapps.compucooking.entities.Ingredient;
import com.specificapps.compucooking.entities.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CompuCookingApplication  {


	public static void main(String[] args) {

       // SpringApplication.run(CompuCookingApplication.class, args);
        try{
            run(args);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


	public static void run(String... args) throws Exception {


        String command = args[0];

        CrudRecipe crudRecipe = new CrudRecipe();


        if(command.equals("create-recipe")){
            System.out.println("Creating Recipe");


            Recipe recipe = new Recipe();
            recipe.setTitle("Mashed Potatoes");
            recipe.setDescription("Buttery and whipped ,and salty.");

            List<Ingredient> mashedPotatoesIngredients = new ArrayList<>();
            Ingredient potatoes = new Ingredient();
            potatoes.setName("Potatoes");
            potatoes.setQuantity(4);
            potatoes.setNote("Russets or Golden are the best");


            Ingredient butter = new Ingredient();
            butter.setName("Butter");
            butter.setOz(10);
            butter.setNote("Irish butter is my choice.");


            mashedPotatoesIngredients.add(potatoes);
            mashedPotatoesIngredients.add(butter);

            recipe.setIngredientList(mashedPotatoesIngredients);


            Author author = new Author();
            author.setFirstName("Mark");
            author.setLastName("Davis");

            recipe.setRecipeAuthor(author);

            crudRecipe.createRecipe(recipe);


            Recipe popcorn = crudRecipe.buildRecipe("Popcorn", "Buttery and easy",
                    "Pico", Arrays.asList("Popcorn kernels", "butter", "salt"));

            crudRecipe.createRecipe(popcorn);

            Recipe grilledCheese = crudRecipe.buildRecipe("Grilled Cheese", "A nostalgic favorite",
                    author, Arrays.asList("American Cheese", "white bread", "butter"));

            crudRecipe.createRecipe(grilledCheese);


            crudRecipe.finish();

        }


        if(command.equals("geo-test")){

            GeoCrud geoCrud = new GeoCrud();

            geoCrud.createGeoPoints();

        }


        if(command.equals("update-author")) {
            System.out.println("Updating Author");

            Author author = new Author();
            author.setFirstName("Nina");
            author.setLastName("Brahme");
            crudRecipe.updateRecipeAuthor(author);



        }

        if(command.equals("update-ingredients")) {
            System.out.println("Updating Ingredients");

            List<Ingredient> ingredients = new ArrayList<>();

            Ingredient milk = new Ingredient();
            milk.setNote("Whole Milk");
            milk.setOz(8);
            milk.setPrice(2.00);
            milk.setQuantity(4);

            ingredients.add(milk);

            crudRecipe.updateRecipeIngredients(ingredients);



        }



	}

}
