package sample;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button Add;

    @FXML
    private Button Delete;

    @FXML
    private TextField Name;

    @FXML
    private TextField Des;

    @FXML
    private TextField Salary;

    @FXML
    private TableView<employee>table;
    @FXML
    private TableColumn<employee,String>NameCol;

    @FXML
    private TableColumn<employee,String>DesCol;

    @FXML
    private TableColumn<employee,String>SalaryCol;

    public void addData(ActionEvent event){
        employee e=new employee();
        e.setName(Name.getText());
        e.setDesignation(Des.getText());
        e.setSalary(Salary.getText());
        table.getItems().add(e);
        Name.setText(" ");
        Des.setText(" ");
        Salary.setText(" ");
    }
    public void DeleteData(ActionEvent event){
        ObservableList<employee> e,allEmp;
        allEmp =table.getItems();
        e =table.getSelectionModel().getSelectedItems();
        e.forEach(allEmp::remove);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NameCol.setCellValueFactory(new PropertyValueFactory<employee,String>("Name"));
        DesCol.setCellValueFactory(new PropertyValueFactory<employee,String>("Designation"));
        SalaryCol.setCellValueFactory(new PropertyValueFactory<employee,String>("Salary"));

    }
}
