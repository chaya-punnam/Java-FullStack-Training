package com.abc.demo.FirstSpringBootMavenProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepo;

    // Insert Records
    public void insertFoodDetails() {

        FoodEntity f1 = new FoodEntity();
        f1.setFoodID(1);
        f1.setFoodName("Idly");
        f1.setFoodCost(100);
        f1.setFoodRating(4);

        foodRepo.save(f1);

        FoodEntity f2 = new FoodEntity();
        f2.setFoodID(2);
        f2.setFoodName("Dosa");
        f2.setFoodCost(200);
        f2.setFoodRating(5);

        foodRepo.save(f2);

        System.out.println("Data is saved successfully!");
    }

    // Read All Records
    public void readAllTheFoods() {

        List<FoodEntity> foodDetails = foodRepo.findAll();

        for (FoodEntity i : foodDetails) {

            System.out.println("Food ID : " + i.getFoodID());
            System.out.println("Food Name : " + i.getFoodName());
            System.out.println("Food Cost : " + i.getFoodCost());
            System.out.println("Food Rating : " + i.getFoodRating());
            System.out.println("========================");
        }
    }

    // Read Record Using ID
    public void readFoodUsingID() {

        FoodEntity foodInfo = foodRepo.findById(2).get();

        System.out.println("Food ID : " + foodInfo.getFoodID());
        System.out.println("Food Name : " + foodInfo.getFoodName());
        System.out.println("Food Cost : " + foodInfo.getFoodCost());
        System.out.println("Food Rating : " + foodInfo.getFoodRating());
    }

    // Delete Record Using ID
    public void deleteParticularFood() {

        foodRepo.deleteById(2);

        System.out.println("Food deleted successfully!");
    }
}