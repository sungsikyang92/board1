package com.mvc.board.dao.sqls;

public class BoardDaoSqls {
	public static final String GET_ALL_BOARD_LIST = "SELECT id,author,title,content,created_date,modified_date FROM board";
	public static final String GET_BOARD_DETAIL_BY_ID = "SELECT id,author,title,content,created_date,modified_date FROM board where id = :id";
}
