package test;

import java.util.List;

import org.hibernate.Transaction;

import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.dao.NewsDao;
import edu.zzuli.assistant.dao.impl.NewsDaoImpl;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 *@author name time 
 *@version version-number
 *@param parameter-name description
 *@return description
 */

public class NewsDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		tx=HibernateUtil.getCurrentSession().beginTransaction();
		News news=new News();
		NewsDao newsDao =new NewsDaoImpl();
		List<News>  news2=newsDao.selectFollowNews("54111201021", 0, 3);
		System.out.print(news2.get(0) instanceof  News);
		for(News s:news2){
			System.out.println(s.getId());
		}
		tx.commit();
	}

}
