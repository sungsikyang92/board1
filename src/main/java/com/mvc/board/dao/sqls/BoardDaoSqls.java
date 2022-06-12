package com.mvc.board.dao.sqls;

public class BoardDaoSqls {
	public static final String GET_ALL_BOARD_LIST = "SELECT id,author,title,content,created_date,modified_date FROM board";
	public static final String GET_BOARD_DETAIL_BY_ID = "SELECT id,author,title,content,created_date,modified_date FROM board where id = :id";
	public static final String INSERT_TO_BOARD = "INSERT INTO board (author, title, content, created_date, modified_date) VALUES (:author, :title, :content, now(), now())";
	public static final String UPDATE_BOARD = "UPDATE board SET author=:author, title=:title, content=:content, modified_date=now() WHERE id = :id";
	public static final String DELETE_BOARD = "DELETE FROM board WHERE id=:id";
}
