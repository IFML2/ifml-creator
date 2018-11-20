module ifml.creator {
    requires javafx.base;
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;
    requires org.slf4j;
    requires java.desktop;
    requires jdk.jsobject;
    exports ifml.creator;
    opens ifml.creator.view to javafx.fxml, javafx.web;
}
