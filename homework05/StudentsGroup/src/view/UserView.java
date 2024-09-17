package view;

import java.util.List;

public interface UserView<T> {
    void sendOnConsole(List<T> list);
}