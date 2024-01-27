package org.vaadin.example.org.vaadin.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LayoutExercise extends VerticalLayout {
    public LayoutExercise() {
        Div header = new Div();
        header.setText("This is the header");
        header.getStyle().set("background-color", "crimson");
        header.setHeight("150px");
        header.setWidth("100%");
        header.getStyle().set("flex-grow", "0");

        Div navigation = new Div();
        navigation.setText("This is the navigation area width = 25%");
        navigation.setWidth("25%");
        navigation.getStyle().set("background-color", "yellow");

        Div contentArea = new Div();
        contentArea.setText("This is the contentArea area width = 75%");
        contentArea.setWidth("75%");
        contentArea.getStyle().set("background-color", "green");

        HorizontalLayout content = new HorizontalLayout();
        content.add(navigation, contentArea);
        content.setWidth("100%");
        content.setSpacing(false);
        content.getStyle().set("flex-grow", "1");

        Div footer = new Div();
        footer.setText("This is the footer");
        footer.getStyle().set("background-color", "blue");
        footer.setHeight("100px");
        footer.setWidth("100%");
        footer.getStyle().set("flex-grow", "0");

        add(header, content, footer);
    }
}
