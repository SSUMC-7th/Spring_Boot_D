package umc.study.ApiPayload.exception.handler;

import umc.study.ApiPayload.code.BaseErrorCode;
import umc.study.ApiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
