package zzz_Observer;

import zzz_Observer.listeners.EmailNotificationListener;
import zzz_Observer.listeners.LogOpenListener;
import zzz_Observer.publisher.EventManager;

import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public static void main(String[] args) {
        // создает в конструкторе объект EventManager и сеттит во внутренне поле
        Editor editor = new Editor();
        // слушатели оба реализуют интерфейс EventListener _ в конструкторе сеттят поля
        // LogOpenListener - из строки делает new File(..)

        // subscribe - получает из listeners мапы, ссылку на список по ключу (open/save - что добавляются
        // при создании Editor и кидает в этот список слушателя т.е. new LogOpenListener)
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));

        // EmailNotificationListener - из строки сетит поле.. String email
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try { // сеттит поле file new File(..)
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        // notify - получает ссылку из мапы, по ключу open
        // потом перебирает через полученную ссылку на список в нем всех слушателей
        // и выполняет на них метод update - выполняется, у каждого слушателя своя реализация метода update()
        // а update() - выводит в консоль _ засеттенное поле слушателя и полученные аргументы из notify()
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
