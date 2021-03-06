/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.tsp.gespro.factory;

import java.sql.Connection;
import com.tsp.gespro.dao.*;
import com.tsp.gespro.jdbc.*;

public class RutaMarcadorDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return RutaMarcadorDao
	 */
	public static RutaMarcadorDao create()
	{
		return new RutaMarcadorDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return RutaMarcadorDao
	 */
	public static RutaMarcadorDao create(Connection conn)
	{
		return new RutaMarcadorDaoImpl( conn );
	}

}
