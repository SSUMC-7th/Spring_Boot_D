package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class RestaurantCategoryHandler extends GeneralException {

    public RestaurantCategoryHandler (BaseErrorCode errorCode) {
        super(errorCode);
    }

}
