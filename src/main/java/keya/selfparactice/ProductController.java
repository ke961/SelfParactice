package keya.selfparactice;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ProductController
{
    @javafx.fxml.FXML
    private TextField pNameTextField;
    @javafx.fxml.FXML
    private ComboBox<Integer> pIDComboBox;
    @javafx.fxml.FXML
    private TableColumn<Product,String> qTC;
    @javafx.fxml.FXML
    private ComboBox<String> pNameComboBox;
    @javafx.fxml.FXML
    private TextArea dTextArea;
    @javafx.fxml.FXML
    private TextField sNameTextField;
    @javafx.fxml.FXML
    private TextField sIDTextField;
    @javafx.fxml.FXML
    private Label massageLable;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> sIDTC;
    @javafx.fxml.FXML
    private ComboBox<String> quantityComboBox;
    @javafx.fxml.FXML
    private TableView<Product> productTableView;
    @javafx.fxml.FXML
    private TableColumn<Product,String> availStatusTC;
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private TableColumn<Product,String> cTC;
    @javafx.fxml.FXML
    private TextField pIdTextField;
    @javafx.fxml.FXML
    private TextField pPriceTextField;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> pIDTC;
    @javafx.fxml.FXML
    private TableColumn<Product,String> pNameTC;
    @javafx.fxml.FXML
    private RadioButton outOfStockRadioButton;
    @javafx.fxml.FXML
    private RadioButton inStockRadioButton;
    @javafx.fxml.FXML
    private TableColumn<Product,Float> pPriceTC;
    @javafx.fxml.FXML
    private TableColumn<Product,String> sNameTC;

    ArrayList<Product>products;
    @javafx.fxml.FXML
    private ToggleGroup toggleGroup;
    @javafx.fxml.FXML
    private Button showDataButton;
    @javafx.fxml.FXML
    private CheckBox checkedCB;
    @javafx.fxml.FXML
    private CheckBox notCheckedCB;

    @javafx.fxml.FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        inStockRadioButton.setToggleGroup(toggleGroup);
        outOfStockRadioButton.setToggleGroup(toggleGroup);
        products = new ArrayList<Product>();
        pNameTC.setCellValueFactory(new PropertyValueFactory<Product,String>("productName"));
        pIDTC.setCellValueFactory(new PropertyValueFactory<Product,Integer>("productId"));
        pPriceTC.setCellValueFactory(new PropertyValueFactory<Product,Float>("productPrice"));
        sNameTC.setCellValueFactory(new PropertyValueFactory<Product,String>("stallName"));
        sIDTC.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stallId"));
        availStatusTC.setCellValueFactory(new PropertyValueFactory<Product,String>("availStatus"));
        qTC.setCellValueFactory(new PropertyValueFactory<Product,String>("quantity"));
        cTC.setCellValueFactory(new PropertyValueFactory<Product,String>("category"));

        categoryComboBox.getItems().addAll("Cloths","Jewellery","Books","Smart Devices");
        quantityComboBox.getItems().addAll("1","2","3","4","5","6","7","8","9");
        showDataButton.setDisable(true);


    }

    @javafx.fxml.FXML
    public void saveBTOnAction(ActionEvent actionEvent) {
        // its better to take row inputs first
        String productName = pNameTextField.getText();
        String stallName = sNameTextField.getText();
        String productDescription = dTextArea.getText();
        String category=categoryComboBox.getValue();
        String quantity= quantityComboBox.getValue();

      // which button is selected right now and gives a selected toggle
       Toggle selectedToggle=toggleGroup.getSelectedToggle();


        // Safe to validate before parsing
        if(productName.isEmpty()
                ||pIdTextField.getText().isEmpty()
                ||quantityComboBox.getValue()==null
                ||category.isEmpty()
        || sIDTextField.getText().isEmpty()
                ||selectedToggle==null
        ||stallName.isEmpty()
        ||productDescription.isEmpty()
        ||pPriceTextField.getText().isEmpty()){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText("Please enter all the fields correctly");
        alert.showAndWait();
        return;
        }

        //safe to parse now otherwise itt will give error
        int productId = Integer.parseInt(pIdTextField.getText());
        float productPrice = Float.parseFloat(pPriceTextField.getText());
        int stallId = Integer.parseInt(sIDTextField.getText());

       //(RadioButton) to access .getText()because only RadioButton has the .getText() method.
        String availStatus=((RadioButton)selectedToggle).getText();


        Product product=new Product(productName,productId,productDescription,productPrice,stallName,stallId,quantity,category,availStatus);
        products.add(product);
        pIDComboBox.getItems().add(productId);
        pNameComboBox.getItems().add(productName);

        massageLable.setText("Product Saved");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("success");
        alert.setContentText("your product has been saved successfully");
        alert.showAndWait();









    }

    @javafx.fxml.FXML
    public void statusCheckedOnMouseClicked(Event event) {
        if(checkedCB.isSelected()){
            showDataButton.setDisable(false);
        }

    }

    @javafx.fxml.FXML
    public void refreshBTOnAction(ActionEvent actionEvent) {
        productTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void statusNotCheckedOnMousClicked(Event event) {
        if(notCheckedCB.isSelected()){
            showDataButton.setDisable(false);
        }
    }

    @javafx.fxml.FXML
    public void deleteDataBTOnAction(ActionEvent actionEvent) {
        productTableView.getItems().remove(productTableView.getSelectionModel().getSelectedItem());
    }

    @javafx.fxml.FXML
    public void showDataBTOnAction(ActionEvent actionEvent) {
        String pName = pNameComboBox.getValue();
       int pId =pIDComboBox.getValue();
       if(pName.isEmpty()||pIDComboBox.getValue()==null){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Invalid Input");
           alert.setContentText("Please enter all the fields correctly");
           alert.showAndWait();
           return;

       }
        for(Product product:products){
            if(product.getProductName().equals(pName)||product.getProductId()==pId){
                productTableView.getItems().add(product);
                break;
            }
        }
    }
}