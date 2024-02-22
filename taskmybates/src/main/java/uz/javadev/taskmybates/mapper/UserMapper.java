package uz.javadev.taskmybates.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import uz.javadev.taskmybates.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from User")
    public List<User> getAllUser();
}
