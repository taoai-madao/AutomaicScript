module com.taoai.automaticscript {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                    requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.taoai.automaticscript to javafx.fxml;
    exports com.taoai.automaticscript;
}