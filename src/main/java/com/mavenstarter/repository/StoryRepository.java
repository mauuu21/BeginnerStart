package com.mavenstarter.repository;

import com.mavenstarter.entity.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {

    //SELECT * FROM STORY
    @Query("select s from Story s")
    List<Story> findAll();

    //SELECT * FROM STORY WHERE posted IN (SELECT max(posted) FROM story) LIMIT 1;
    Story findFirstByOrderByPostedDesc();

    //@Query(value = "select * from story where title = ?1 limit 1", nativeQuery = true)
    //@Query(value = "select * from story where title = :title limit 1", nativeQuery = true)
    @Query("select s from Story s where s.title = :title limit 1")
    Story findByTitle(@Param("title")String title);

    List<Story> findAllByBloggerNameIgnoreCaseOrderByPostedDesc(String name);

    //JDBC examp.
//    private JdbcTemplate jdbc;
//
//    @Autowired
//    public StoryRepository(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    public List<Story> findAll() {
//        String sql = "select * from story order by posted";
//        return jdbc.query(sql, (rs, i) -> new Story(
//                rs.getLong("id"),
//                rs.getString("title"),
//                rs.getString("content"),
//                rs.getDate("posted"),
//                rs.getLong("blogger_id")
//
//        ));
//    };
}
