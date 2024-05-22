package com.example.spring_phoneshop.mapper;

import com.example.spring_phoneshop.dto.RoleDTO;
import com.example.spring_phoneshop.dto.UserDTO;
import com.example.spring_phoneshop.entity.Role;
import com.example.spring_phoneshop.entity.User;
import com.example.spring_phoneshop.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class RoleMapper {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;

    public RoleDTO mapToRoleDTO(GrantedAuthority authority){
        String roleName = authority.getAuthority();
        Role role = roleRepository.findByRoleName(roleName).get();
        RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
        return roleDTO;
    }

    public RoleDTO mapToRoleDTO(Role role){
        RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
        return roleDTO;
    }
    public Role mapToRoleEntity (RoleDTO roleDTO){
        Role role = modelMapper.map(roleDTO, Role.class);
        return role;
    }
}
