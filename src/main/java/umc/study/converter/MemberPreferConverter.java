package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.web.dto.MemberRequestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }

}
