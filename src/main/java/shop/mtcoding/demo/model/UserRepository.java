package shop.mtcoding.demo.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository { // CRUD
    // Create
    public int insert(@Param("username") String username, @Param("password") String password,
            @Param("email") String email);

    // Read
    public List<User> findAll();

    public User findById();

    // Update
    public int updateById(@Param("id") int id, @Param("password") String password);

    // Delete
    public int deleteById(int id);

    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
