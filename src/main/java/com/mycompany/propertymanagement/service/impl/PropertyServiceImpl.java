package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository repository;
    @Autowired
    private PropertyConverter converter;

    @Override
    public PropertyDTO save(PropertyDTO dto) {
        PropertyEntity e = repository.save(converter.convertDtoToEntity(dto));
        return converter.convertEntityToDto(e);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> eList = (List<PropertyEntity>) repository.findAll();
        List<PropertyDTO> dtoList = new ArrayList<>();

        for (PropertyEntity e : eList) {
            dtoList.add(converter.convertEntityToDto(e));
        }

        return dtoList;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PropertyDTO update(PropertyDTO dto, Long id) {
        Optional<PropertyEntity> opt = repository.findById(id);
        if (opt.isPresent()) {
            PropertyEntity e = opt.get();
            e.setAddress(dto.getAddress());
            e.setDescription(dto.getDescription());
            e.setOwnerEmail(dto.getOwnerEmail());
            e.setOwnerName(dto.getOwnerName());
            e.setPrice(dto.getPrice());
            e.setTitle(dto.getTitle());

            repository.save(e);

            return converter.convertEntityToDto(e);
        }
        return null;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO dto, Long id) {
        Optional<PropertyEntity> opt = repository.findById(id);
        if (opt.isPresent()) {
            PropertyEntity e = opt.get();
            e.setDescription(dto.getDescription());

            repository.save(e);

            return converter.convertEntityToDto(e);
        }
        return null;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO dto, Long id) {
        Optional<PropertyEntity> opt = repository.findById(id);
        if (opt.isPresent()) {
            PropertyEntity e = opt.get();
            e.setPrice(dto.getPrice());

            repository.save(e);

            return converter.convertEntityToDto(e);
        }
        return null;
    }
}
