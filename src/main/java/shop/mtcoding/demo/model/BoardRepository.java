package shop.mtcoding.demo.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
    // Create
    public int insert();

    // Read
    public List<Board> findAll();

    public Board finrOne();

    // Update
    public int update();

    // Delete
    public int delete();

}
