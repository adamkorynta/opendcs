/**
 * $Id$
 * 
 * $Log$
 */
package opendcs.dai;

import java.util.Collection;
import java.util.Optional;

import org.opendcs.database.api.DataTransaction;
import org.opendcs.database.api.OpenDcsDao;
import org.opendcs.database.api.OpenDcsDataException;

import decodes.db.DbEnum;
import decodes.db.EnumList;
import decodes.db.EnumValue;
import decodes.sql.DbKey;
import decodes.tsdb.DbIoException;

/**
 * Data Access Interface for database-resident enumerations
 * @author mmaloney Mike Maloney
 */
public interface EnumDAI extends DaiBase
{
	DbEnum getEnum(String enumName)
		throws DbIoException;

	void readEnumList(EnumList top)
		throws DbIoException;

	void writeEnumList(EnumList enumList)
		throws DbIoException;

	void writeEnum(DbEnum dbenum)
		throws DbIoException;

	DbKey getEnumId(String enumName)
		throws DbIoException;

	void deleteEnumList(DbKey refListId)
		throws DbIoException;

	EnumValue getEnumValue(DbKey id, String enumVal)
		throws DbIoException;

	void deleteEnumValue(DbKey id, String enumVal)
		throws DbIoException;

	void writeEnumValue(DbKey enumId, EnumValue enumVal, String fromAbbr, int sortNum)
		throws DbIoException;
	
	void close();
}
