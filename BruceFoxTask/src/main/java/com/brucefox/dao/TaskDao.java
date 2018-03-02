package com.brucefox.dao;

import java.util.List;
import com.brucefox.model.Task;

public interface TaskDao {

	public boolean addEntity(Task task) throws Exception;
	public Task getEntityById(long id) throws Exception;
	public List<Task> getEntityList() throws Exception;
	public Task updateTask(Task task) throws Exception;
	/*public boolean deleteEntity(long id) throws Exception;*/
}
