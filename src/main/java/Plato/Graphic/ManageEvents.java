package Plato.Graphic;

import Plato.Controller.MainPageAdminController;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Event;
import Plato.View.MainPageAdmin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.regex.Pattern;

public class ManageEvents {

@FXML
    public TextField gameName;
@FXML
    public TextField endDate;
@FXML
    public TextField score;
@FXML
    public TextField startDate;
@FXML
TextField url = new TextField();
@FXML
javafx.scene.image.ImageView image = new javafx.scene.image.ImageView();
@FXML
TextField eid = new TextField();
@FXML
    TextArea events = new TextArea();
@FXML
TextField nval = new TextField();
@FXML
    ChoiceBox<String> cho = new ChoiceBox<>();
@FXML
    public void addEvent(ActionEvent actionEvent) throws Exception {
        int id = Event.getEvents().size();
        MainPageAdminController.getInstance().addEvent(gameName.getText(),startDate.getText(),endDate.getText(), Integer.parseInt(score.getText()));
        if (!url.getText().equals(""))
        {
            for (Event event : Event.getEvents()) {
                if (event.getEventId()==id+1)
                {
                    event.imageURL=url.getText();
                }
            }
        }
    }
    @FXML
    public void showAllEvents(ActionEvent event)
    {
        String allEvent = MainPageAdminController.getInstance().viewEvents();
        events.setText(allEvent);

        ObservableList aa = FXCollections.observableArrayList("name","startdate","enddate","score");
        cho.setItems(aa);
    }

    @FXML
    public void showSpecific(ActionEvent event1)
    {
        String id = eid.getText();
        String specific = MainPageAdminController.getInstance().viewEvent(Integer.parseInt(id));
        events.setText(specific);
        for (Event event : Event.getEvents()) {
            if (event.getEventId()==Integer.parseInt(id))
            {
                if (!event.imageURL.equals(""))
                {
                    image = new ImageView(event.imageURL);
                }
            }
        }
    }

    @FXML
    public void edit(ActionEvent event)
    {
        MainPageAdminController.getInstance().editEvent(cho.getValue(),nval.getText(),Integer.parseInt(eid.getText()));
    }

    @FXML
    public void remove(ActionEvent event)
    {
        for (Event event1 : Event.getEvents()) {
            if (event1.getEventId()==Integer.parseInt(eid.getText()))
            {
                Event.getEvents().remove(event1);
            }
        }
    }

    @FXML
    public void AccountMenu(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAAM);
    }

    @FXML
    public void AdminGame(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAG);
    }

    @FXML
    public void ManageEvent(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootME);
    }

    @FXML
    public void AdminBot(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAB);
    }

    @FXML
    public void Logout(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.root);
    }


}
