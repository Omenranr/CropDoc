package dao;

import java.util.ArrayList;

import model.Request;
import model.User;

public interface RequestDao {
	void saveRequest(Request request, long user_id);
	ArrayList<Request> getUserRequests(User user);
}
