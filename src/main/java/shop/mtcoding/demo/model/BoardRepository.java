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
    public int update();

    // Delete
    public int delete();

    public Board findList(@Param("id") int id);

}
