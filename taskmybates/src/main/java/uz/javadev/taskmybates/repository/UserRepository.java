package uz.javadev.taskmybates.repository;

import org.apache.ibatis.annotations.*;
import uz.javadev.taskmybates.model.Users;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("select * from users")
    public List<Users> getAllUser();

    @Select("select * from users")
    @Results({
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "address", column = "address")
    })
    public List<Users> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "address", column = "address")
    })
    Optional<Users> findById(long id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO users(id, first_name, last_name,address) " +
            " VALUES (#{id}, #{firstName}, #{lastName}, #{address})")
    public int insert(Users user);


    @Update("Update users set first_name=#{firstName}, " +
            " last_name=#{lastName}, address=#{address} where id=#{id}")
    void update(Users user);
}
