package javaFxExp;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);   // запуск приложения
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Stage - главное окно содержащее все остальные слои
        // стэйджей может быть много

        String pathForVideo = "D:\\z__mm_video\\Clips_R\\Stone & Van Linden Feat. Lyck - Into The Light (Donzelli & Sanders Remix) 720p.mp4";

        // Подгружаем наше видео наместо скринсэвейра _ заставки _ и плэйер для воспроизведения
        File file = new File(pathForVideo);
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // Настраиваем MediaView вывод видео
        DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
        mediaView.setPreserveRatio(true);

        // контейнер группы объектов
        StackPane root = new StackPane();
        root.getChildren().add(mediaView);

        // слой
        Scene scene = new Scene(root, 500, 500, Color.BLACK);

        // настраиваем главное окно
        primaryStage.setTitle("My ScreenSaver");
        primaryStage.setFullScreen(true);
        primaryStage.show();

        // запускаем воспроизведение
        mediaPlayer.play();
    }


}
