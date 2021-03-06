package edu.uark.models.repositories;

import java.sql.SQLException;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface {
	@Override
	public TransactionEntity byRecordID(int recordid, String field) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.NONE).  //change postgre function to nonn so it doesn't modify my record id integer value in where statement.
					table(this.primaryTable).
					fieldName((field.equals("RECORD_ID")) ? TransactionFieldNames.RECORD_ID : TransactionFieldNames.REFERENCE_ID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setInt(1, recordid);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public int countTransaction() {
		return this.count();
	}
	
	@Override
	public TransactionEntity createOne() {
		return new TransactionEntity();
	}
	
	public TransactionRepository() {
		super(DatabaseTable.TRANSACTION);
	}
}
