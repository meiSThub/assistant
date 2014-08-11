/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import edu.zzuli.assistant.bean.Notice;
import edu.zzuli.assistant.dao.impl.NoticeDaoImpl;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 *@author name time 
 *@version version-number
 *@param parameter-name description
 *@return description
 */

public class NoticeDaoTest {

	/**
	 * @param args
	 */
	@Test
	public void init(){
		Session session=HibernateUtil.getCurrentSession();
		Transaction tx=session.beginTransaction();
		NoticeDaoImpl noticeDaoImpl=new NoticeDaoImpl();
		//Notice notice=noticeDaoImpl.selectById(1);
		//noticeDaoImpl.deleteById(2);
		//System.out.print(notice.getTitle());
		List<Notice> notices=new ArrayList<Notice>();
		notices=noticeDaoImpl.selectNotic(3,3);
		System.out.println(notices.size());
		for(Notice n:notices){
			System.out.println(n.getTitle()+"-----------"+n.getPostTime());
		}
		
		tx.commit();
	}

}
