package cn.com.lingnan.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lingnan.mapper.UserMapper;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.UserExample;
import cn.com.lingnan.pojo.UserExample.Criteria;
import cn.com.lingnan.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

  

    @Override
	public User login(User user) {
    	UserExample userExample = new  UserExample();
    	Criteria criteria = userExample.createCriteria();
    	criteria.andUsernameEqualTo(user.getUsername());
    	criteria.andPasswordEqualTo(user.getPassword());
    	List<User> selectByExample = userMapper.selectByExample(userExample);
    	if(selectByExample.isEmpty()){
    		return null;
    	}
    	user = selectByExample.get(0);
		return user;
		
	}



    @Override
    public boolean updateByID(User user) {
    	int updateByPrimaryKeySelective = userMapper.updateByPrimaryKeySelective(user);
    	if(1==updateByPrimaryKeySelective){
    		return true;
    	}
        return false;
    }
    
    
    

}
