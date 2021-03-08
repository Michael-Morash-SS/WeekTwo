/**
 * 
 */
package com.ss.assignments.utopia.services;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Michael
 *
 */
public class SessionFactorySingletonWrapper {
	private static volatile SessionFactory instance;
	
	public static SessionFactory getInstance() {
		if (instance == null) {
			synchronized (SessionFactorySingletonWrapper.class) {
				if (instance == null) {
					final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
							.configure()
							.build();
					
					try { 
						instance = new MetadataSources(registry).buildMetadata().buildSessionFactory();
					} catch (Exception e) {
						System.out.println(e);
						System.exit(0);
						StandardServiceRegistryBuilder.destroy(registry);
					}
				}
			}
		}
		
		return instance;
	}
}
