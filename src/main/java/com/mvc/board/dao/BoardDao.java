package com.mvc.board.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.board.dto.BoardDto;

import static com.mvc.board.dao.sqls.BoardDaoSqls.*;

import java.util.List;

import javax.sql.DataSource;

@Repository
public class BoardDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<BoardDto> rowMapper = BeanPropertyRowMapper.newInstance(BoardDto.class);
	
	public BoardDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<BoardDto> getAllBoardList() {
		return jdbc.query(GET_ALL_BOARD_LIST, EmptySqlParameterSource.INSTANCE, rowMapper);
	}
}
