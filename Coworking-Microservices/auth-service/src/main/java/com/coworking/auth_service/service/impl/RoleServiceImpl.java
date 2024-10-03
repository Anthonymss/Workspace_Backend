package com.coworking.auth_service.service.impl;

import com.coworking.auth_service.persistence.entity.Role;
import com.coworking.auth_service.persistence.repository.RoleRepository;
import com.coworking.auth_service.presentation.dto.RoleDto;
import com.coworking.auth_service.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    //private final RoleMapper roleMapper;


    @Override
    public RoleDto createRole(RoleDto roleDto) {
        //Role role = roleMapper.toEntity(roleDto);
        //Role savedRole = roleRepository.save(role);
        return null;//roleMapper.toDTO(savedRole);
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        //return roleMapper.toDTO(role);
        return null;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return null;/*roleRepository.findAll().stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
    */
    }

    @Override
    public RoleDto updateRole(Long id, RoleDto roleDto) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        existingRole.setName(roleDto.getName());
        existingRole.setDescription(roleDto.getDescription());
        return null;//roleMapper.toDTO(roleRepository.save(existingRole));
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
