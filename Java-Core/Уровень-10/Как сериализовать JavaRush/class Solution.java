import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/*
JavaRush. Java Core. Уровень 20. Лекция 4. (2007)

Как сериализовать JavaRush?

Сделай так, чтобы сериализация класса JavaRush была возможной.
*/

public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
