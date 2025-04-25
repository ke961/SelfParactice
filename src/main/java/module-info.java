module keya.selfparactice {
    requires javafx.controls;
    requires javafx.fxml;


    opens keya.selfparactice to javafx.fxml;
    exports keya.selfparactice;


}