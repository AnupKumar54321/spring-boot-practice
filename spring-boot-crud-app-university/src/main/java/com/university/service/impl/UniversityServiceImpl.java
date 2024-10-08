package com.university.service.impl;

import com.university.dto.SearchDTO;
import com.university.dto.UniversityDTO;
import com.university.dto.UniversitySearchResponseDTO;
import com.university.entity.UniversityEntity;
import com.university.repository.UniversityRepo;
import com.university.service.UniversityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepo universityRepo;

    @Override
    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setUniversityId(universityDTO.getUniversityId());
        universityEntity.setUniversityName(universityDTO.getUniversityName());
        universityEntity.setAddress(universityDTO.getAddress());
        universityEntity.setCreatedBy(universityDTO.getCreatedBy());
        UniversityEntity  universityRes = universityRepo.save(universityEntity);
        UniversityDTO universityDTOResponse = new UniversityDTO();
        universityDTOResponse.setCreatedBy(universityRes.getCreatedBy());
        universityDTOResponse.setUniversityId(universityRes.getUniversityId());
        universityDTOResponse.setAddress(universityRes.getAddress());
        universityDTOResponse.setUniversityName(universityRes.getUniversityName());
        return universityDTOResponse;
    }

    @Override
    public List<UniversityDTO> allUniversity() {
        List<UniversityDTO> dtos= new ArrayList<>();
        List<UniversityEntity> universityEntityList = universityRepo.findAll();
        universityEntityList.forEach(u->{
            UniversityDTO universityDTOResponse = new UniversityDTO();
            universityDTOResponse.setCreatedBy(u.getCreatedBy());
            universityDTOResponse.setUniversityId(u.getUniversityId());
            universityDTOResponse.setAddress(u.getAddress());
            universityDTOResponse.setUniversityName(u.getUniversityName());
            dtos.add(universityDTOResponse);
        });

        return dtos;
    }

    @Override
    public UniversityDTO updateUniversity(UniversityDTO universityDTO) {
        UniversityDTO universityDTOResponse = new UniversityDTO();
        //check in db
        Optional<UniversityEntity> universityEntity  = universityRepo.findById(universityDTO.getUniversityId());
        if(universityEntity.isPresent()) {
            universityEntity.get().setAddress(universityDTO.getAddress());
            universityEntity.get().setUpdatedBy("CURRENT_USER");
            UniversityEntity updatedUniversityData =  universityRepo.save(universityEntity.get());
            universityDTOResponse.setCreatedBy(updatedUniversityData.getCreatedBy());
            universityDTOResponse.setUniversityId(updatedUniversityData.getUniversityId());
            universityDTOResponse.setAddress(updatedUniversityData.getAddress());
            universityDTOResponse.setUniversityName(updatedUniversityData.getUniversityName());
            universityDTOResponse.setUpdatedBy(updatedUniversityData.getUpdatedBy());
        }

        return universityDTOResponse;
    }

    @Override
    public boolean deleteUniversityById(String universityId) {

        //check the DB record is exist or not
        Optional<UniversityEntity> universityEntity = universityRepo.findById(universityId);
        if(universityEntity.isPresent()) {
            universityRepo.deleteById(universityId);
            return true;
        }
        return false;
    }

    @Override
    public UniversityDTO findBYNameAndId(String universityId, String universityName) {
        UniversityEntity universityEntity = universityRepo.findByUniversityIdAndUniversityName(universityId,universityName);
        UniversityDTO universityDTO = new UniversityDTO();
        BeanUtils.copyProperties(universityEntity,universityDTO);
        return universityDTO;
    }

    @Override
    public UniversityDTO findBYNameAndIdJPQL(String universityId, String universityName) {
        UniversityEntity universityEntity = universityRepo.findByUniversityIdAndUniversityNameUsingJPQL(universityId,universityName);
        UniversityDTO universityDTO = new UniversityDTO();
        BeanUtils.copyProperties(universityEntity,universityDTO);
        return universityDTO;
    }

    @Override
    public UniversityDTO findBYNameAndIdNative(String universityId, String universityName) {
        UniversityEntity universityEntity = universityRepo.findByUniversityIdAndUniversityNameUsingNative(universityId,universityName);
        UniversityDTO universityDTO = new UniversityDTO();
        BeanUtils.copyProperties(universityEntity,universityDTO);
        return universityDTO;
    }

    @Override
    public List<UniversityDTO> findAllByState(List<String> state) {
        return mapToUniversityDTO(universityRepo.findAllByStateIn(state));
    }

    @Override
    public List<UniversityDTO> findAllByStateNamed(List<String> state) {
        return mapToUniversityDTO(universityRepo.findAllByStateIn(state));
    }

    @Override
    public List<UniversityDTO> findAllByStateNamedNative(List<String> state) {
        return mapToUniversityDTO(universityRepo.findAllByStateIn(state));
    }

    @Override
    public UniversitySearchResponseDTO searchUniversity(SearchDTO searchDTO) {

        Pageable pageable = PageRequest.of(searchDTO.getPageNum(),searchDTO.getPageSize());

        Page<UniversityEntity> universityEntities = universityRepo.findAllByUniversityNameContainsIgnoreCase(searchDTO.getUniversityName(),pageable);
        UniversitySearchResponseDTO universitySearchResponseDTO = new UniversitySearchResponseDTO();
        universitySearchResponseDTO.setTotalPage(universityEntities.getTotalPages());
        universitySearchResponseDTO.setTotalRecord(universityEntities.getTotalElements());
        universitySearchResponseDTO.setUniversities(mapToUniversityDTO(universityEntities.getContent()));
        return universitySearchResponseDTO;

    }

    private List<UniversityDTO> mapToUniversityDTO(List<UniversityEntity> universityEntityList) {
        List<UniversityDTO> universityDTOList = new ArrayList<>();
        universityEntityList.forEach(u -> {
            UniversityDTO universityDTO = new UniversityDTO();
            BeanUtils.copyProperties(u, universityDTO);
            universityDTOList.add(universityDTO);
        });
        return universityDTOList;
    }
}
