package uz.javadev.taskmybates.mapper;

import org.apache.ibatis.annotations.*;
import uz.javadev.taskmybates.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from User")
    public List<User> getAllUser();

    @Select("select * from user")
    public List <User> findAll();

    @Select("SELECT * FROM employees WHERE id = #{id}")
    public User findById(long id);

    @Delete("DELETE FROM employees WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO employees(id, first_name, last_name,email_address) " +
            " VALUES (#{id}, #{firstName}, #{lastName}, #{emailId})")
    public int insert(User employee);

    @Update("Update employees set first_name=#{firstName}, " +
            " last_name=#{lastName}, email_address=#{emailId} where id=#{id}")
    public int update(User employee);
}
