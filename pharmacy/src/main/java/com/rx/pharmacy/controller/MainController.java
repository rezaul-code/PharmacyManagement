package com.rx.pharmacy.controller;

import com.rx.pharmacy.model.Medicine;
import com.rx.pharmacy.repository.MedicineRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField manufacturerField;

    @FXML
    private TextField priceField;

    @FXML
    private Button addButton;

    @FXML
    private TableView<Medicine> medicineTable;

    @FXML
    private TableColumn<Medicine, String> nameColumn;

    @FXML
    private TableColumn<Medicine, String> manufacturerColumn;

    @FXML
    private TableColumn<Medicine, Double> priceColumn;

    private final MedicineRepository medicineRepository;
    private final ObservableList<Medicine> medicineList = FXCollections.observableArrayList();

    public MainController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @FXML
    public void initialize() {
        // Bind columns
        nameColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getName()));
        manufacturerColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getManufacturer()));
        priceColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleObjectProperty<>(cell.getValue().getPrice()));

        // Load existing medicines
        medicineList.addAll(medicineRepository.findAll());
        medicineTable.setItems(medicineList);
    }

    @FXML
    private void handleAddMedicine() {
        String name = nameField.getText();
        String manufacturer = manufacturerField.getText();
        double price = Double.parseDouble(priceField.getText());

        Medicine medicine = new Medicine(name, manufacturer, price);
        medicineRepository.save(medicine);
        medicineList.add(medicine);

        // Clear fields
        nameField.clear();
        manufacturerField.clear();
        priceField.clear();
    }
}
