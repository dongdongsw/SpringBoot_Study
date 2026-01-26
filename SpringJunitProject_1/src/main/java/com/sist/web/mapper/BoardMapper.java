package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.BoardVO;

@Mapper
@Repository
public interface BoardMapper {

	/*
	 <select id="boardListData" resultType="com.sist.web.vo.BoardVO">
 		SELECT no, subject, name, DATE_FORMAT(regdate, '%Y-%m-%d') as dbdat, hit
 		FROM board
 		ORDER BY no DESC
 		LIMIT #{start},10
 	</select>
 	<!-- 
 		count()
 	 -->
 	<select id="boardTotalPage" resultType="int">
 		SELECT CEIL(COUNT(*)/10.0) FROM board
 	</select>
	 */
	public List<BoardVO> boardListData(int start);
	
	public int boardTotalPage();
	/*
	<insert id="boardInsert">
		INSERT INTO board(name, subject, content, pwd)
		VALUES(#{name},#{subject},#{content},#{pwd})
	</insert>
	*/
	
	public void boardInsert(BoardVO vo);
	/*
	 <update id="hitIncrement">
 		UPDATE board SET
 		hit = hit + 1
 		WHERE no = #{no}
 	</update>
 	
 	<select id="boardDetailData" resultType="com.sist.web.vo.BoardVO">
 		SELECT no, name, subject, content, hit,
 			DATE_FORMAT(regdate, '%Y-%m-%d') as dbday
 		FROM board
 		WHERE no = #{no}
 	</select>
	 */
	public void hitIncrement(int no);
	
	public BoardVO boardDetailData(int no);
	
}
