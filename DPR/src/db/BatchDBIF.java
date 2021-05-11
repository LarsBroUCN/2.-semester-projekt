package db;

import model.Batch;

public interface BatchDBIF {
	public Batch searchBatch(int batchID) throws DataAccessException;

}
