package pagetest.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import pagetest.entity.User;
import pagetest.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	protected static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Transactional(readOnly = true)
	public PageInfo<User> findAll(String username, Date birthday, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);

		Example example = new Example(User.class);
		if (!StringUtils.isEmpty(username)) {
			example.createCriteria().andEqualTo("username", username);
		}
		if (birthday != null) {
			example.createCriteria().andEqualTo("birthday", birthday);
		}
		List<User> users = userMapper.selectByExample(example);
		return new PageInfo<>(users);

	}
	
	@Transactional(readOnly = true)
	public PageInfo<User> findAll(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);

		List<User> users = userMapper.getAll();
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		//logger.debug(pageInfo.toString());
		return pageInfo;

	}

}
