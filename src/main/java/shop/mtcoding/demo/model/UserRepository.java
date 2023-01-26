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

        public User findOne(@Param("id") int id);

        // Update
        public int updateByUsernamePasswordEmail(@Param("id") int id, @Param("username") String username,
                        @Param("password") String password,
                        @Param("email") String email);

        // Delete

        public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
