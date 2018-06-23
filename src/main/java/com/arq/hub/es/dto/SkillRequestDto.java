package com.arq.hub.es.dto;

import com.arq.hub.es.dto.Impl.DTO;

import java.util.Objects;

public class SkillRequestDto extends DTO {


    private long skillId;
    private String skillName;

    public SkillRequestDto() {
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillRequestDto)) return false;
        SkillRequestDto that = (SkillRequestDto) o;
        return getSkillId() == that.getSkillId() &&
                Objects.equals(getSkillName(), that.getSkillName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSkillId(), getSkillName());
    }
}
