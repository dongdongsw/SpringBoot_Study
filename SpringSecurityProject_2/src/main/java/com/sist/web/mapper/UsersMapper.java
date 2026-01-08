package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.UserRolesVO;
import com.sist.web.vo.Users_1VO;

@Repository
@Mapper
public interface UsersMapper {
	
	@Insert("INSERT INTO users_1(username, password) VALUES(#{username},#{password}) ")
	public void userInsert(Users_1VO vo);
	
	@Insert("INSERT INTO user_roles(user_id, role_name) VALUES(#{user_id},#{role_name}) ")
	public void userRoleInsert(UserRolesVO vo);
	
	
	@Select("SELECT * FROM users_1 WHERE username = #{username}")
	public Users_1VO findByUsername(String username);
	
	@Select("SELECT role_name FROM user_roles WHERE user_id = #{user_Id}")
	public List<String> findRolesByUserId(int userId);
	
	// 로그인 ...
	
}
 	