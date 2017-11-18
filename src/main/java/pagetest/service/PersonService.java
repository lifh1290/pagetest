package pagetest.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import pagetest.entity.Person;
import pagetest.mapper.PersonMapper;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
public class PersonService {
	@Autowired
	private PersonMapper personMapper;
	
	protected static Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	@Transactional(readOnly = true)
	public PageInfo<Person> findAll(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		
		List<Person> Persons = personMapper.findAll();
		//分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
		//logger.debug("getTotal:"+((Page<Person>) Persons).getPages());
		PageInfo<Person> pageInfo = new PageInfo<Person>(Persons);
		
		/*
		//第六种，ISelect 接口方式
		//jdk6,7用法，创建接口
		Page<Person> page0 = PageHelper.startPage(1, 10).doSelectPage(new ISelect() {
			@Override
			public void doSelect() {
				personMapper.findAll();
			}
		});
		logger.debug(page0.toString());
		//jdk8 lambda用法
		Page<Person> page1 = PageHelper.startPage(page, pageSize).doSelectPage(()-> personMapper.findAll());
		
		logger.debug(page1.toString());

		//也可以直接返回PageInfo，注意doSelectPageInfo方法和doSelectPage
		PageInfo<Person> pageInfo = PageHelper.startPage(page, pageSize).doSelectPageInfo(new ISelect() {
			@Override
			public void doSelect() {
				personMapper.findAll();
			}
		});
		logger.debug(pageInfo.toString());
		//对应的lambda用法
		pageInfo = PageHelper.startPage(page, pageSize).doSelectPageInfo(() -> personMapper.findAll());
		*/
		logger.debug(pageInfo.toString());
		return pageInfo;

	}
	
	@Transactional(readOnly = true)
	public PageInfo<Person> findAll(String name, String age, Integer page, Integer pageSize) {
		Example example = new Example(Person.class);
		if (!StringUtils.isEmpty(name)) {
			example.createCriteria().andEqualTo("name", name);
		}
		if (!StringUtils.isEmpty(age)) {
			example.createCriteria().andEqualTo("age", age);
		}
		PageHelper.startPage(page, pageSize);
		List<Person> users = personMapper.selectByExample(example);
		return new PageInfo<>(users);

	}

}
