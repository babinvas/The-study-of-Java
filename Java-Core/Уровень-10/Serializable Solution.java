import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

/*
JavaRush. Java Core. Уровень 20. Лекция 7. (2014)

Serializable Solution

Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));

        File file = new File("F:\\vas.txt");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            Solution savedObject = new Solution(30);

            out.writeObject(savedObject);
            out.flush();
            out.close();

            Solution loadedObject = new Solution(5);

            loadedObject = (Solution) in.readObject();

            System.out.println(savedObject.string.equals(loadedObject.string));

            in.close();
        }
        catch(FileNotFoundException e) {
        }
        catch(ClassNotFoundException e) {
        }
        catch (IOException e) {
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    public transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
