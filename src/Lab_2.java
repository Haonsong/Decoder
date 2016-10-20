/**
 * Created by remi on 10/14/16.
 */

import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextArea;
        import javafx.scene.layout.*;
        import javafx.stage.FileChooser;
        import javafx.stage.Stage;
        import javafx.scene.media.Media;
        import javafx.scene.media.MediaPlayer;

        import java.io.File;
        import java.nio.file.*;
        import java.io.IOException;

        import java.awt.Desktop;
        import java.io.File;
        import java.io.IOException;
        import java.util.List;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.geometry.Insets;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.Pane;
        import javafx.scene.layout.VBox;
        import javafx.stage.FileChooser;
        import javafx.stage.Stage;






public class Lab_2 extends  Application{
    public static void main(String []args){
//        System.out.print("Hello world!");
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LAB 2: Signal Processing");

        // the file holder
        File file =null;

        // New textArea
        BorderPane border = new BorderPane();
        Button btn_start = new Button();
        Button btn_play = new Button();
        TextArea txtA = new TextArea();
        txtA.setWrapText(true);
        txtA.setEditable(false);
        txtA.setPrefSize(480,450);
        VBox vbox = new VBox(txtA);

        // New button

        btn_start.setText("Start");
        btn_start.setPrefSize(300, 50);
        btn_play.setText("Play");
        btn_play.setPrefSize(300, 50);


        btn_start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                process(btn_start);
            }
        });
        btn_play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                open_File(primaryStage,file);
//                System.out.print( file.getName());
            }
        });
        HBox hBox = new HBox(btn_play,btn_start);

        // add the component to boarder
        border.setCenter(vbox);
        border.setBottom(hBox);

        // add the boarder to container
        primaryStage.setScene(new Scene(border, 600 , 500));
        if(file != null){
            System.out.print("Music!\n");
            String music_name = file.getName();
            Media media = new Media(music_name);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }
        primaryStage.show();
    }

    public void process(Button btn){
        String button;
        button = btn.getText();

        if (button.equals("Start")){
            System.out.print("Processing..\n");

            btn.setText("Cancel");
        }else {
            btn.setText("Start");
        }

    }

    public void open_File(Stage stage, File file){
        Desktop desktop = Desktop.getDesktop();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file =  fileChooser.showOpenDialog(stage);
        try {
            desktop.open(file);
        } catch (IOException ex) {

        }
    }
}
