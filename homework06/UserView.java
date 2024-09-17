package view;

import java.util.List;

// Принцип Разделения Интерфейсов (ISP): Интерфейс UserView определяет только один метод для отправки данных на консоль.
public interface UserView<T> {
    void sendOnConsole(List<T> list);
}