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

public class TipoRutaDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return TipoRutaDao
	 */
	public static TipoRutaDao create()
	{
		return new TipoRutaDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return TipoRutaDao
	 */
	public static TipoRutaDao create(Connection conn)
	{
		return new TipoRutaDaoImpl( conn );
	}

}
