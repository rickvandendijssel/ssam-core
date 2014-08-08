package com.ssam.core.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public abstract class AbstractDataFilter implements DataFilter {
	
	protected List<Order> orderList = new ArrayList<Order>();
	protected Integer maxResult;
	protected Integer firstResult;
	
	public void setOrderList(List<Order> orderList){
		this.orderList = orderList;
	}
	
	public List<Order> getOrderList(){
		return orderList;
	}
	
	public void setMaxResult(Integer maxResult){
		this.maxResult = maxResult;
	}
			
	public Integer getMaxResult(){
		return maxResult;
	}
	
	public void setFirstResult(Integer firstResult){
		this.firstResult = firstResult;
	}
			
	public Integer getFirstResult(){
		return firstResult;
	}
	
	@Override
	public void setFilter(Criteria criteria) {
		if(orderList.size() > 0){
			for(Order order : orderList){
				criteria.addOrder(order);
			}
		}
		if(maxResult != null){
			criteria.setMaxResults(maxResult);
		}
		if(firstResult !=null){
			criteria.setFirstResult(firstResult);
		}
	}

}
