package com.doney.japdemo.entity;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;


public class LogInterceptor extends EmptyInterceptor {
 
	private static final long serialVersionUID = 1L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

		return false;
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

		return false;
	}
}
