package pagetest.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import pagetest.Application;
import pagetest.entity.Person;
import pagetest.mapper.PersonMapper;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class pagetest {
	
	@Autowired
	PersonMapper personMapper;
	
	@Test
	public void pagetperson() throws Exception {
		//Example example = new Example(Person.class);

		PageHelper.startPage(1, 4);
		//List<Person> persons = personMapper.selectByExample(example);
		List<Person> persons = personMapper.findAll();
		PageInfo<Person> pageInfo = new PageInfo<Person>(persons);
		System.out.println("pageInfo:"+pageInfo.getPages());
	}
	

}
