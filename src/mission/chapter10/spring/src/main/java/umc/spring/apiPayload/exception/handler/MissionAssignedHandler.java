package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class
MissionAssignedHandler extends GeneralException {

    public MissionAssignedHandler (BaseErrorCode errorCode) {
        super(errorCode);
    }

}
