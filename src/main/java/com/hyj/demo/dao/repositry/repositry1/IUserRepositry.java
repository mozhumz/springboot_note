package com.hyj.demo.dao.repositry.repositry1;

import com.hyj.demo.entity.po.po1.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositry extends JpaRepository<UserPO, Long> {
}
