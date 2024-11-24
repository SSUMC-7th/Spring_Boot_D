package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.UserPreferredFood;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {

    public static List<UserPreferredFood> toUserPreferList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserPreferredFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }

}
