package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.BoardVO;

@Mapper
@Repository
public interface BoardMapper {

	/*
	 <select id="boardListData" resultType="com.sist.web.vo.BoardVO" parameterType="hashmap">
 		SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num
 		FROM (SELECT no, subject, name, regdate, hit, rownum as num
 		FROM (SELECT no, subject, name, regdate, hit
 		FROM springReplyBoard ORDER BY group_id DESC, group_step ASC))
 		WHERE num BETWEEN #{start} AND #{end}
 	</select>
 	
 	<select id="boardCountRow" resultType="int">
 		SELECT COUNT(*) FROM SpringReplyBoard
 	</select>
 	
 	<insert id="boardInsert" parameterType="com.sist.web.vo.BoardVO">
 		INSERT INTO springReplyBoard(no, subject, content, pwd, group_id)
 		VALUES(srb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, 
 			(SELECT NVL(MAX(group_id)+1,1) 
 		FROM springReplyBoard))
 	</insert>
	 */
	// 리스트
	public List<BoardVO> boardListData(Map map);
	
	public int boardCountRow();
	
	public void boardInsert(BoardVO vo);
	
	/*
	 <update id="boardHitIncrement" parameterType="int">
 		UPDATE springReplyBoard SET 
 		hit = hit + 1
 		WHERE no = #{no}
 	</update>
 	
 	<select id="boardDetailData" resultType="com.sist.web.vo.BoardVO" parameterType="int">
 		SELECT no, name, subject, content, hit, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday
 		FROM springReplyBoard
 		WHERE no = #{no}
 	</select>
	 */
	// 디테일
	public BoardVO boardDetailData(int no);
	
	public void boardHitIncrement(int no);
	
	
	/*
	 <select id="boardGetPassword" resultType="string" parameterType="int">
 		SELECT pwd FROM springReplyBoard
 		WHERE no = #{no}
 	</select>
 	
 	<update id="boardUpdate" parameterType="com.sist.web.vo.BoardVO">
 		UPDATE springReplyBoard SET
 		name=#{name}, subject=#{subject}, content=#{content}
 		WHERE no=#{no}
 	</update>
	 */
	// 수정
	public String boardGetPassword(int no);
	
	public void boardUpdate(BoardVO vo);
	
	/*
	 <select id="boardParentInfoData" resultType="com.sist.web.vo.BoardVO" parameterType="int">
	 		SELECT gorup_id, group_step, group_tab
	 		FROM springReplyBoard
	 		WHERE no = #{no}
	 	</select>
	 	
	 	<update id="boardGroupStepIncrement" parameterType="com.sist.web.vo.BoardVO">
	 		UPDATE springReplyBoard SET
	 		group_step = group_step + 1
	 		WHERE group_id = #{group_id} AND group_step = #{group_step} 
	 	</update>
	 	
	 	<!-- 데이터 추가 -->
	 	<insert id="boardReplyInsert" parameterType="com.sist.web.vo.BoardVO">
	 		INSERT INTO springReplyBoard(no, name, subject, content, pwd, group_id, group_step, group_tab, root)
	 		VALUES(srb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, #{group_id}, #{group_step}, #{group_tab}, #{root})
	 	</insert>
 		
 		<update id="boardDepthIncrement" parameterType="int">
 			UPDATE springReplyBoard SET
 			depth = depth+1
 			WHERE no = #{no}
 		</update>
	 */
	// 답변
	public BoardVO boardParentInfoData(int no);
	
	public void boardGroupStepIncrement(BoardVO vo);
	
	public void boardReplyInsert(BoardVO vo);
	
	public void boardDepthIncrement(int no);
	
	/*
	 <select id="boardDeleteInfoData" resultType="com.sist.web.vo.BoardVO" parameterType="int">
 		SELECT depth, root FROM springReplyBoard
 		WHERE no = #{no}
 	</select>
 	
 	<update id="boardSubjectChange" parameterType="int">
 		UPDATE springReplyBoard SET
 		subject = '관리자에 의해 삭제된 게시물입니다',
 		content = '관리자에 의해 삭제된 게시물입니다'
 		WHERE no = #{no}
 	</update>	
 	
 	<delete id="boardDelete" parameterType="int">
 		DELETE FROM springReplyBoard
 		WHERE no = #{no}
 	</delete>
 	
 	<update id="boardDepthDecrement" parameterType="int">
 		UPDATE springReplyBoard SET 
 		depth=depth-1
 		WHERE no = #{no}
 	</update>
	 */
	
	//삭제 
	public BoardVO boardDeleteInfoData(int no);
	
	public void boardSubjectChange(int no);
	
	public void boardDelete(int no);
	
	public void boardDepthDecrement(int no);
}
