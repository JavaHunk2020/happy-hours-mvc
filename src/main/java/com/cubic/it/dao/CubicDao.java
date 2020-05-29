package com.cubic.it.dao;

import java.util.List;

import com.cubic.it.dao.entity.BlockTimeEntity;
import com.cubic.it.dao.entity.UserEntity;

public interface CubicDao {

	public UserEntity authUser(String username, String password);

	List<BlockTimeEntity> findBlockTimes();

	void deleteUserByUserid(String userid);

	String forgetPassword(String email);

	public  List<UserEntity>  searchUser(String searchText);

}
