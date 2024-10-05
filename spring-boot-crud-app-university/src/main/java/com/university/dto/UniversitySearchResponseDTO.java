package com.university.dto;

import java.util.List;

public class UniversitySearchResponseDTO {

    private Long totalRecord;
    private int totalPage;
    private List<UniversityDTO> universities;

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<UniversityDTO> getUniversities() {
        return universities;
    }

    public void setUniversities(List<UniversityDTO> universities) {
        this.universities = universities;
    }
}
