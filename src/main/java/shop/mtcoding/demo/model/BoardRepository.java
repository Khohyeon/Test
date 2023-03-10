package shop.mtcoding.demo.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {
    // Create
    public int insert();

    // Read

    public List<Board> findAll();

    // Update
    public int update(@Param("username") String username, @Param("password") String password,
            @Param("email") String email);

    // Delete
    public int delete();

    public List<Board> findList(@Param("id") int id);

}
