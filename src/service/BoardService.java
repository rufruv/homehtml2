package service;

import domain.ArticleBean;
import java.util.*;

public interface BoardService {
	public void add(ArticleBean param);
	public ArticleBean findOne(ArticleBean param);
	public List<ArticleBean> findSome(ArticleBean param);
	public List<ArticleBean> list();
	public void update(ArticleBean param);
	public void delete(ArticleBean param);	
}