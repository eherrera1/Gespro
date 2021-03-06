/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.tsp.gespro.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the relacion_concepto_competencia table.
 */
public class RelacionConceptoCompetenciaPk implements Serializable
{
	protected int idRelacion;

	/** 
	 * This attribute represents whether the primitive attribute idRelacion is null.
	 */
	protected boolean idRelacionNull;

	/** 
	 * Sets the value of idRelacion
	 */
	public void setIdRelacion(int idRelacion)
	{
		this.idRelacion = idRelacion;
	}

	/** 
	 * Gets the value of idRelacion
	 */
	public int getIdRelacion()
	{
		return idRelacion;
	}

	/**
	 * Method 'RelacionConceptoCompetenciaPk'
	 * 
	 */
	public RelacionConceptoCompetenciaPk()
	{
	}

	/**
	 * Method 'RelacionConceptoCompetenciaPk'
	 * 
	 * @param idRelacion
	 */
	public RelacionConceptoCompetenciaPk(final int idRelacion)
	{
		this.idRelacion = idRelacion;
	}

	/** 
	 * Sets the value of idRelacionNull
	 */
	public void setIdRelacionNull(boolean idRelacionNull)
	{
		this.idRelacionNull = idRelacionNull;
	}

	/** 
	 * Gets the value of idRelacionNull
	 */
	public boolean isIdRelacionNull()
	{
		return idRelacionNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof RelacionConceptoCompetenciaPk)) {
			return false;
		}
		
		final RelacionConceptoCompetenciaPk _cast = (RelacionConceptoCompetenciaPk) _other;
		if (idRelacion != _cast.idRelacion) {
			return false;
		}
		
		if (idRelacionNull != _cast.idRelacionNull) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + idRelacion;
		_hashCode = 29 * _hashCode + (idRelacionNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.tsp.gespro.dto.RelacionConceptoCompetenciaPk: " );
		ret.append( "idRelacion=" + idRelacion );
		return ret.toString();
	}

}
