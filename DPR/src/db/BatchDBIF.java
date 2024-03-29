package db;

import java.util.List;
import model.Batch;
import model.Status;

public interface BatchDBIF {
	public Batch searchBatch(int batchID) throws DataAccessException;
	public List<Batch> findAllByStatus(Status status) throws DataAccessException;
	public void updateBatch(Batch batch) throws DataAccessException;
	public List<Batch> findAllNotNotification() throws DataAccessException;
}