package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDtoToEntity(PropertyDTO dto) {
        PropertyEntity e = new PropertyEntity();
        e.setTitle(dto.getTitle());
        e.setOwnerEmail(dto.getOwnerEmail());
        e.setAddress(dto.getAddress());
        e.setOwnerName(dto.getOwnerName());
        e.setDescription(dto.getDescription());
        e.setPrice(dto.getPrice());

        return e;
    }

    public PropertyDTO convertEntityToDto(PropertyEntity e) {
        PropertyDTO dto = new PropertyDTO();
        dto.setAddress(e.getAddress());
        dto.setDescription(e.getDescription());
        dto.setPrice(e.getPrice());
        dto.setOwnerEmail(e.getOwnerEmail());
        dto.setTitle(e.getTitle());
        dto.setOwnerName(e.getOwnerName());
        dto.setId(e.getId());

        return dto;
    }
}
