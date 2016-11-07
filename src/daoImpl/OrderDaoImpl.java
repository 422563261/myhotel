package daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.OrderDao;
import entity.Order;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	@Override
	public void saveOrder(Order order) {
		this.getHibernateTemplate().save(order);
		
	}

	@Override
	public void removeOrder(Order order) {
		this.getHibernateTemplate().delete(order);
		
	}

	@Override
	public void updateOrder(Order order) {
		this.getHibernateTemplate().update(order);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findOrderByName(String name) {
		String hql = "from Order order where order.name='"+name+"'";
		return this.getHibernateTemplate().find(hql);
	}


}
