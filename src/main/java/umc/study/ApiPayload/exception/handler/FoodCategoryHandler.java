package umc.study.ApiPayload.exception.handler;

import umc.study.ApiPayload.code.BaseErrorCode;
import umc.study.ApiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
