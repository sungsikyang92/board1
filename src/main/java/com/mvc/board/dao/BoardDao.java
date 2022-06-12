package com.mvc.board.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mvc.board.dto.BoardDto;

import static com.mvc.board.dao.sqls.BoardDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

@Repository
public class BoardDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<BoardDto> listRowMapper = BeanPropertyRowMapper.newInstance(BoardDto.class);
	private RowMapper<BoardDto> detailRowMapper = BeanPropertyRowMapper.newInstance(BoardDto.class);
//	private SimpleJdbcInsert insertJdbc;
	
	public BoardDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
//		this.insertJdbc = new SimpleJdbcInsert(dataSource)
//				.withTableName("board")
//				.usingGeneratedKeyColumns("id");
	}
	
	public List<BoardDto> getAllBoardList() {
		return jdbc.query(GET_ALL_BOARD_LIST, EmptySqlParameterSource.INSTANCE, listRowMapper);
	}
	
	public List<BoardDto> getBoardDetailById(int id) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		return jdbc.query(GET_BOARD_DETAIL_BY_ID, params, detailRowMapper);
	}
	
	public int insertToBoard(BoardDto boardDto) {
//		SqlParameterSource params = new BeanPropertySqlParameterSource(boardDto);
//		return insertJdbc.executeAndReturnKey(params).intValue();
		Map<String, Object> params = new HashMap<>();
		params.put("author", boardDto.getAuthor());
		params.put("title", boardDto.getTitle());
		params.put("content", boardDto.getContent());
		return jdbc.update(INSERT_TO_BOARD, params);
	}
	
	public int updateBaord(BoardDto boardDto) {
		Map<String, Object> params = new HashMap<>();
		params.put("author", boardDto.getAuthor());
		params.put("title", boardDto.getTitle());
		params.put("content", boardDto.getContent());
		params.put("modified_date",	boardDto.getModifiedDate());
		params.put("id", boardDto.getId());
		return jdbc.update(UPDATE_BOARD, params);
	}

	public int deleteBoard(int id) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		return jdbc.update(DELETE_BOARD, param);
	}
}
