package com.cap.washer.services;


import com.cap.washer.models.WasherInfo;
import com.cap.washer.repository.WasherInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasherInfoServiceImpl implements WasherInfoService {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    WasherInfoRepository washerInfoRepository;

    @Override
    public WasherInfo insertWasherInfo(WasherInfo washerInfo) {
        washerInfo.setWasherId(sequenceGeneratorService.getSequenceNumber(WasherInfo.SEQUENCE_NAME));
        return washerInfoRepository.save(washerInfo);
    }

    @Override
    public List<WasherInfo> getAllWashers() {
        return washerInfoRepository.findAll();
    }

    @Override
    public WasherInfo findByWasherEmail(String washerEmail) {
        return washerInfoRepository.findByWasherEmail(washerEmail);
    }

    @Override
    public WasherInfo updateWasherInfo(WasherInfo washerInfo, int washerId) {
        WasherInfo wI= washerInfoRepository.findById(washerId).get();
        wI.setWasherName(washerInfo.getWasherName());
        wI.setWasherEmail(washerInfo.getWasherEmail());
        wI.setWasherPassword(washerInfo.getWasherPassword());
        return washerInfoRepository.save(wI);
    }

    @Override
    public void deleteWasherInfo(int userId) {
          washerInfoRepository.deleteById(userId);
    }

    @Override
    public WasherInfo getById(int washerId) {
        return washerInfoRepository.findById(washerId).get();
    }


}
