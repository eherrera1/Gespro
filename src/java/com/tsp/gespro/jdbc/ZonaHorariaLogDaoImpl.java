/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.tsp.gespro.jdbc;

import com.tsp.gespro.dao.*;
import com.tsp.gespro.factory.*;
import java.util.Date;
import com.tsp.gespro.dto.*;
import com.tsp.gespro.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ZonaHorariaLogDaoImpl extends AbstractDAO implements ZonaHorariaLogDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT ID_ZONA_HORARIA_LOG, ID_EMPRESA, ID_USUARIOS, DESCRIPCION, FECHA FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ID_ZONA_HORARIA_LOG, ID_EMPRESA, ID_USUARIOS, DESCRIPCION, FECHA ) VALUES ( ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET ID_ZONA_HORARIA_LOG = ?, ID_EMPRESA = ?, ID_USUARIOS = ?, DESCRIPCION = ?, FECHA = ? WHERE ID_ZONA_HORARIA_LOG = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ID_ZONA_HORARIA_LOG = ?";

	/** 
	 * Index of column ID_ZONA_HORARIA_LOG
	 */
	protected static final int COLUMN_ID_ZONA_HORARIA_LOG = 1;

	/** 
	 * Index of column ID_EMPRESA
	 */
	protected static final int COLUMN_ID_EMPRESA = 2;

	/** 
	 * Index of column ID_USUARIOS
	 */
	protected static final int COLUMN_ID_USUARIOS = 3;

	/** 
	 * Index of column DESCRIPCION
	 */
	protected static final int COLUMN_DESCRIPCION = 4;

	/** 
	 * Index of column FECHA
	 */
	protected static final int COLUMN_FECHA = 5;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 5;

	/** 
	 * Index of primary-key column ID_ZONA_HORARIA_LOG
	 */
	protected static final int PK_COLUMN_ID_ZONA_HORARIA_LOG = 1;

	/** 
	 * Inserts a new row in the zona_horaria_log table.
	 */
	public ZonaHorariaLogPk insert(ZonaHorariaLog dto) throws ZonaHorariaLogDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			StringBuffer sql = new StringBuffer();
			StringBuffer values = new StringBuffer();
			sql.append( "INSERT INTO " + getTableName() + " (" );
			int modifiedCount = 0;
			if (dto.isIdZonaHorariaLogModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "ID_ZONA_HORARIA_LOG" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (dto.isIdEmpresaModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "ID_EMPRESA" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (dto.isIdUsuariosModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "ID_USUARIOS" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (dto.isDescripcionModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "DESCRIPCION" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (dto.isFechaModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "FECHA" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (modifiedCount==0) {
				// nothing to insert
				throw new IllegalStateException( "Nothing to insert" );
			}
		
			sql.append( ") VALUES (" );
			sql.append( values );
			sql.append( ")" );
			stmt = conn.prepareStatement( sql.toString(), Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			if (dto.isIdZonaHorariaLogModified()) {
				stmt.setInt( index++, dto.getIdZonaHorariaLog() );
			}
		
			if (dto.isIdEmpresaModified()) {
				stmt.setInt( index++, dto.getIdEmpresa() );
			}
		
			if (dto.isIdUsuariosModified()) {
				stmt.setInt( index++, dto.getIdUsuarios() );
			}
		
			if (dto.isDescripcionModified()) {
				stmt.setString( index++, dto.getDescripcion() );
			}
		
			if (dto.isFechaModified()) {
				stmt.setTimestamp(index++, dto.getFecha()==null ? null : new java.sql.Timestamp( dto.getFecha().getTime() ) );
			}
		
			System.out.println( "Executing " + sql.toString() + " with values: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdZonaHorariaLog( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ZonaHorariaLogDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the zona_horaria_log table.
	 */
	public void update(ZonaHorariaLogPk pk, ZonaHorariaLog dto) throws ZonaHorariaLogDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			StringBuffer sql = new StringBuffer();
			sql.append( "UPDATE " + getTableName() + " SET " );
			boolean modified = false;
			if (dto.isIdZonaHorariaLogModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "ID_ZONA_HORARIA_LOG=?" );
				modified=true;
			}
		
			if (dto.isIdEmpresaModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "ID_EMPRESA=?" );
				modified=true;
			}
		
			if (dto.isIdUsuariosModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "ID_USUARIOS=?" );
				modified=true;
			}
		
			if (dto.isDescripcionModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "DESCRIPCION=?" );
				modified=true;
			}
		
			if (dto.isFechaModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "FECHA=?" );
				modified=true;
			}
		
			if (!modified) {
				// nothing to update
				return;
			}
		
			sql.append( " WHERE ID_ZONA_HORARIA_LOG=?" );
			System.out.println( "Executing " + sql.toString() + " with values: " + dto );
			stmt = conn.prepareStatement( sql.toString() );
			int index = 1;
			if (dto.isIdZonaHorariaLogModified()) {
				stmt.setInt( index++, dto.getIdZonaHorariaLog() );
			}
		
			if (dto.isIdEmpresaModified()) {
				stmt.setInt( index++, dto.getIdEmpresa() );
			}
		
			if (dto.isIdUsuariosModified()) {
				stmt.setInt( index++, dto.getIdUsuarios() );
			}
		
			if (dto.isDescripcionModified()) {
				stmt.setString( index++, dto.getDescripcion() );
			}
		
			if (dto.isFechaModified()) {
				stmt.setTimestamp(index++, dto.getFecha()==null ? null : new java.sql.Timestamp( dto.getFecha().getTime() ) );
			}
		
			stmt.setInt( index++, pk.getIdZonaHorariaLog() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ZonaHorariaLogDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the zona_horaria_log table.
	 */
	public void delete(ZonaHorariaLogPk pk) throws ZonaHorariaLogDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getIdZonaHorariaLog() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ZonaHorariaLogDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the zona_horaria_log table that matches the specified primary-key value.
	 */
	public ZonaHorariaLog findByPrimaryKey(ZonaHorariaLogPk pk) throws ZonaHorariaLogDaoException
	{
		return findByPrimaryKey( pk.getIdZonaHorariaLog() );
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the criteria 'ID_ZONA_HORARIA_LOG = :idZonaHorariaLog'.
	 */
	public ZonaHorariaLog findByPrimaryKey(int idZonaHorariaLog) throws ZonaHorariaLogDaoException
	{
		ZonaHorariaLog ret[] = findByDynamicSelect( SQL_SELECT + " WHERE ID_ZONA_HORARIA_LOG = ?", new Object[] {  new Integer(idZonaHorariaLog) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the criteria ''.
	 */
	public ZonaHorariaLog[] findAll() throws ZonaHorariaLogDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY ID_ZONA_HORARIA_LOG", null );
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the criteria 'ID_ZONA_HORARIA_LOG = :idZonaHorariaLog'.
	 */
	public ZonaHorariaLog[] findWhereIdZonaHorariaLogEquals(int idZonaHorariaLog) throws ZonaHorariaLogDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_ZONA_HORARIA_LOG = ? ORDER BY ID_ZONA_HORARIA_LOG", new Object[] {  new Integer(idZonaHorariaLog) } );
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the criteria 'ID_EMPRESA = :idEmpresa'.
	 */
	public ZonaHorariaLog[] findWhereIdEmpresaEquals(int idEmpresa) throws ZonaHorariaLogDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_EMPRESA = ? ORDER BY ID_EMPRESA", new Object[] {  new Integer(idEmpresa) } );
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the criteria 'ID_USUARIOS = :idUsuarios'.
	 */
	public ZonaHorariaLog[] findWhereIdUsuariosEquals(int idUsuarios) throws ZonaHorariaLogDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_USUARIOS = ? ORDER BY ID_USUARIOS", new Object[] {  new Integer(idUsuarios) } );
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the criteria 'DESCRIPCION = :descripcion'.
	 */
	public ZonaHorariaLog[] findWhereDescripcionEquals(String descripcion) throws ZonaHorariaLogDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE DESCRIPCION = ? ORDER BY DESCRIPCION", new Object[] { descripcion } );
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the criteria 'FECHA = :fecha'.
	 */
	public ZonaHorariaLog[] findWhereFechaEquals(Date fecha) throws ZonaHorariaLogDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHA = ? ORDER BY FECHA", new Object[] { fecha==null ? null : new java.sql.Timestamp( fecha.getTime() ) } );
	}

	/**
	 * Method 'ZonaHorariaLogDaoImpl'
	 * 
	 */
	public ZonaHorariaLogDaoImpl()
	{
	}

	/**
	 * Method 'ZonaHorariaLogDaoImpl'
	 * 
	 * @param userConn
	 */
	public ZonaHorariaLogDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "zona_horaria_log";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ZonaHorariaLog fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ZonaHorariaLog dto = new ZonaHorariaLog();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ZonaHorariaLog[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ZonaHorariaLog dto = new ZonaHorariaLog();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ZonaHorariaLog ret[] = new ZonaHorariaLog[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ZonaHorariaLog dto, ResultSet rs) throws SQLException
	{
		dto.setIdZonaHorariaLog( rs.getInt( COLUMN_ID_ZONA_HORARIA_LOG ) );
		dto.setIdEmpresa( rs.getInt( COLUMN_ID_EMPRESA ) );
		dto.setIdUsuarios( rs.getInt( COLUMN_ID_USUARIOS ) );
		dto.setDescripcion( rs.getString( COLUMN_DESCRIPCION ) );
		dto.setFecha( rs.getTimestamp(COLUMN_FECHA ) );
		reset(dto);
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ZonaHorariaLog dto)
	{
		dto.setIdZonaHorariaLogModified( false );
		dto.setIdEmpresaModified( false );
		dto.setIdUsuariosModified( false );
		dto.setDescripcionModified( false );
		dto.setFechaModified( false );
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the specified arbitrary SQL statement
	 */
	public ZonaHorariaLog[] findByDynamicSelect(String sql, Object[] sqlParams) throws ZonaHorariaLogDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ZonaHorariaLogDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the zona_horaria_log table that match the specified arbitrary SQL statement
	 */
	public ZonaHorariaLog[] findByDynamicWhere(String sql, Object[] sqlParams) throws ZonaHorariaLogDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ZonaHorariaLogDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
