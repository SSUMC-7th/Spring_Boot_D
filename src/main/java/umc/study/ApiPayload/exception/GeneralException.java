package umc.study.ApiPayload.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.ApiPayload.code.BaseErrorCode;
import umc.study.ApiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
