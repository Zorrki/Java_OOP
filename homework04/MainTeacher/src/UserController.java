package homework04.MainTeacher.src;
public interface UserController<T extends User> {
	void create(String surname, String firstname, String patronymic);
}
