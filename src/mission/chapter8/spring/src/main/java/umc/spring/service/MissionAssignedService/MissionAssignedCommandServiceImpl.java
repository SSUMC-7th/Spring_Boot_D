package umc.spring.service.MissionAssignedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MissionAssignedHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MissionAssignedConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionAssigned;
import umc.spring.repository.MissionAssignedRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.validation.validator.MissionAssignedExistValidator;
import umc.spring.web.dto.MissionAssignedRequestDTO;

@Service
public class MissionAssignedCommandServiceImpl implements MissionAssignedCommandService {

    private final MissionAssignedRepository missionAssignedRepository;
    private final MissionRepository missionRepository;
    private final MissionAssignedConverter missionAssignedConverter;

    @Autowired
    public MissionAssignedCommandServiceImpl(MissionAssignedRepository missionAssignedRepository, MissionRepository missionRepository, MissionAssignedConverter missionAssignedConverter) {
        this.missionAssignedConverter = missionAssignedConverter;
        this.missionRepository = missionRepository;
        this.missionAssignedRepository = missionAssignedRepository;
    }

    @Override
    @Transactional
    public MissionAssigned joinMissionAssigned(MissionAssignedRequestDTO.JoinDto request, Long missionId, Long userId) {
        // 레스토랑 존재 여부 확인
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MissionAssignedExistValidator missionAssignedValidator = new MissionAssignedExistValidator(missionAssignedRepository);
        missionAssignedValidator.initialize(missionId);
        if (!missionAssignedValidator.isValid(request, null)) {
            throw new MissionAssignedHandler(ErrorStatus.MISSION_ALREADY_ASSIGNED);
        }

        MissionAssigned newMissionAssigned = missionAssignedConverter.toMissionAssigned(request, mission);
        return missionAssignedRepository.save(newMissionAssigned);
    }
}