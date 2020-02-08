package dao;


import java.util.ArrayList;


import model.Task;

import model.User;
import model.Worker;

public interface UserDao {
	
	boolean register(User user,String type_user);
	boolean updateProfil(User user);
	boolean login( User user) ;
	String getUserType(User user);
	boolean emailAlreadyExist( String email) ;
	boolean emailAlreadyExist_withException(String email,String oldEmail);

	boolean add_worker(Worker worker);
	Worker getWorkerById(Long id);
	void deleteWorker(Long id);
	void finishTask(Task tache);

}
