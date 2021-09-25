package com.ghstudio.pairprogram.dao.repository;

import com.ghstudio.pairprogram.dao.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleRepository {
    Role getRoleByID(int id);
}
