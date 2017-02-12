package serviceImpl;

import java.util.*;

import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImple implements BoardService{
	private List<ArticleBean> list;
	
	public BoardServiceImple() {
		list = new ArrayList<ArticleBean>();
	}
	@Override
	public void add(ArticleBean param) {
		list.add(param);
	}

	@Override
	public ArticleBean findOne(ArticleBean param) {
		ArticleBean article = new ArticleBean();
		for(int i=0;i<list.size();i++){
			if(param.getSeq().equals(list.get(i).getSeq())){
				article=list.get(i);
				break;
			}
		}
		return article;
	}

	@Override
	public List<ArticleBean> findSome(ArticleBean param) {
		List<ArticleBean> listSome = new ArrayList<ArticleBean>();
			for(int i=0;i<list.size();i++){
				if(param.getSeq().equals(list.get(i).getSeq())){
					listSome.add(list.get(i));
				}
			}
		return listSome;
	}

	@Override
	public List<ArticleBean> list() {
		return list;
	}

	@Override
	public void update(ArticleBean param) {
		for(int i=0;i<list.size();i++){
			if(param.getSeq().equals(list.get(i).getSeq())){
				String a =(param.getId().equals(""))?list.get(i).getId():param.getId();
				String b =(param.getTitle().equals(""))?list.get(i).getTitle():param.getTitle();
				String c =(param.getContents().equals(""))?list.get(i).getContents():param.getContents();
				list.get(i).setId(a);
				list.get(i).setTitle(b);
				list.get(i).setContents(c);
			}
		}
	}

	@Override
	public void delete(ArticleBean param) {
		Iterator<ArticleBean> it = list.iterator(); // Iterator<ArticleBean>->어떤 객체를 죽일지 지정해주면 더 빠르다!
		while(it.hasNext()){
			if(it.next().getSeq().equals(param.getSeq())){
				it.remove();
				break;
			}
		}
	}
}
