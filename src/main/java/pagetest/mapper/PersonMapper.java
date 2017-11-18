package pagetest.mapper;

import java.util.List;
import pagetest.entity.Person;
import pagetest.util.MyMapper;


/** 
 * 加上這個 extends MyMapper<Person> 才能解決以下報錯 :
 * nested exception is tk.mybatis.mapper.MapperException: 无法获取实体类pagetest.entity.Person对应的表名!] 
 * with root cause tk.mybatis.mapper.MapperException: 无法获取实体类pagetest.entity.Person对应的表名!
 * @author F0829168
 *
 */
public interface PersonMapper extends MyMapper<Person> {
	public List<Person> findAll();
	public Person findByid(Long id);
	public int insert(Person p);
	public void update(Person p);
}
