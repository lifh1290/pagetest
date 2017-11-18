package pagetest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pagetest.entity.User;
import tk.mybatis.mapper.entity.Example;


public interface UserMapper {
	@Select("SELECT * FROM user_tab")
	List<User> getAll();

	@Select("SELECT * FROM user_tab WHERE userid_col = #{userid}")
	User getOne(String userid);

	@Insert("INSERT INTO user_tab(userName,passWord,user_sex,nick_name) VALUES(#{userName}, #{passWord}, #{userSex}, #{nickName})")
	void insert(User user);

	@Update("UPDATE user_tab SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM user_tab WHERE userid_col =#{userid}")
	void delete(String userid);

	@Select("SELECT count(*) as c FROM user_tab")
	int selectPageListCount(Object object);
	
	//@Select("select * from user_tab order by userid_col limit #{page.start},#{page.row}")//這是Mysql的寫法
	
	@Select("SELECT top(#{page.row}) * FROM user_tab WHERE userid_col not in (SELECT top(#{page.start}) userid_col FROM user_tab)")
	List<User> selectPageList(Map<String, Object> map);

	List<User> selectByExample(Example example);

}
