package test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.dao.NewsPicDao;
import edu.zzuli.assistant.dao.impl.NewsDaoImpl;
import edu.zzuli.assistant.dao.impl.NewsPicDaoImpl;
import edu.zzuli.assistant.service.NewsService;
import edu.zzuli.assistant.service.impl.NewsServiceImpl;


public class NewsServiceTest {
	
	
	// 测试未通过 分页语句写错  修改后成功
	@Test
	public void testGetNewsList() {
		
		NewsService newsService = new NewsServiceImpl();
		// 获取公告栏信息
		assertEquals(5, newsService.getNewsList(1, 5).size());
	}
	
	// 测试未通过 分页语句写错  修改后成功
	@Test
	public void test() {
		
			News news =  new NewsDaoImpl().selectById(1);
			NewsPicDao newsPicDao = new NewsPicDaoImpl();
			newsPicDao.selectNewsPic(news.getId());
			System.out.println(news.getTitle());

		NewsService newsService = new NewsServiceImpl();
		// 获取公告栏信息
		assertEquals(5, newsService.getNewsList(1, 5).size());
	}

}
