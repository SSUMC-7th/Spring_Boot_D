package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {

    public UserHandler (BaseErrorCode errorCode) {
        super(errorCode);
    }

}
