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

import java.util.Optional;

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

    @Override
    @Transactional
    public void completeMission(MissionAssignedRequestDTO.JoinDto request, Long userId, Long missionId) {
        // 미션이 이미 할당되어 있는지 검증
        MissionAssignedExistValidator missionAssignedExistValidator = new MissionAssignedExistValidator(missionAssignedRepository);
        missionAssignedExistValidator.initialize(missionId);
        if (missionAssignedExistValidator.isValid(request, null)) {
            throw new MissionAssignedHandler(ErrorStatus.MISSION_ASSIGNED_NOT_FOUND);
        }

        // 미션 존재 확인
        MissionAssigned missionAssigned = missionAssignedRepository.findByUserIdAndMissionId(userId, missionId)
                .orElseThrow(() -> new MissionAssignedHandler(ErrorStatus.MISSION_ASSIGNED_NOT_FOUND));

        // 이미 완료된 미션인지 확인
        if (missionAssigned.getIsCompleted()) {
            throw new MissionAssignedHandler(ErrorStatus.MISSION_ASSIGNED_ALREADY_COMPLETED);
        }

        // 미션 완료 상태 업데이트
        missionAssigned.setIsCompleted(true);
        missionAssignedRepository.save(missionAssigned);
    }

}