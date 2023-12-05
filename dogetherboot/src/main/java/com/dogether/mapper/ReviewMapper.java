package com.dogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dogether.domain.Review;

@Mapper
public interface ReviewMapper {

    @Select("select * from tblreview where place_id=${place_id} order by review_id desc")
    List<Review> selectAll(int place_id);

    @Insert("insert into tblreview (review_id, user_id, user_nickname,"
            + "place_id, review_title, review_content, review_starRating) "
            + "values(review_id_seq.nextval, ${user_id}, ${user_nickname},"
            + "${place_id}, ${review_title}, ${review_content}, ${review_starRating})")
    int insertReview(Review review);

    @Select("update user_nickname, review_title, review_content, user_id,"
            + "place_id, review_starRating FROM tblreview where review_id=${review_id}")
    Review selectReview(int review_id);

    @Update("update tblreview set review_title=${review_title}, review_content=${review_content}"
            + "WHERE review_id=${review_id}")
    void updateReview(Review review);

    @Delete("delete from tblreview where review_id=${review_id}")
    void deleteReview(int review_id);

}
