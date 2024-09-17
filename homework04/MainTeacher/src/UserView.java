import java.util.List;

import model.User;

public interface UserView<T extends User> {
	public void sendOnConsole(List<T> list);
}
