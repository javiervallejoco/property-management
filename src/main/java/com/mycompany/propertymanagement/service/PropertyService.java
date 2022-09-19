package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    PropertyDTO save(PropertyDTO dto);

    List<PropertyDTO> getAllProperties();

    PropertyDTO update(PropertyDTO dto, Long id);

    PropertyDTO updateDescription(PropertyDTO dto, Long id);

    PropertyDTO updatePrice(PropertyDTO dto, Long id);

    void delete(Long id);

}
