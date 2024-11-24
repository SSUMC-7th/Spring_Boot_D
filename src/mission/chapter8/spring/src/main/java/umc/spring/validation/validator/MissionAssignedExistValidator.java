package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.spring.repository.MissionAssignedRepository;
import umc.spring.validation.annotation.ExistMissionAssigned;
import umc.spring.web.dto.MissionAssignedRequestDTO;

@Component
public class MissionAssignedExistValidator implements ConstraintValidator<ExistMissionAssigned, MissionAssignedRequestDTO.JoinDto> {

    @Autowired
    private final MissionAssignedRepository missionAssignedRepository;

    private Long missionIdFromPath;

    public MissionAssignedExistValidator(MissionAssignedRepository missionAssignedRepository) {
        this.missionAssignedRepository = missionAssignedRepository;
    }

    //  @Override
    public void initialize(Long missionId) {
        missionIdFromPath = missionId;
    }

    @Override
    public boolean isValid(MissionAssignedRequestDTO.JoinDto value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Long userId = value.getUserId();
        Long missionId = missionIdFromPath;

        if (userId == null || missionId == null) {
            return true;
        }

        boolean isAssigned = missionAssignedRepository.existsByUserIdAndMissionId(userId, missionId);

        return !isAssigned;
    }

}