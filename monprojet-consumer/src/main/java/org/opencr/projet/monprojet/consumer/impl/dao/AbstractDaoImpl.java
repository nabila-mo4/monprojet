package org.opencr.projet.monprojet.consumer.impl.dao;

import javax.sql.DataSource;

public class AbstractDaoImpl {
	
	private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }

}
