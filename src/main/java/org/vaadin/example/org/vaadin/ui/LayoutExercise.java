package org.vaadin.example.org.vaadin.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LayoutExercise extends VerticalLayout {
    public LayoutExercise() {
        Div header = new Div();
        header.addClassName("header");
        header.setText("This is the header");
        header.setHeight("150px");
        header.setWidth("100%");
        header.getStyle().set("flex-shrink", "0");

        Div navigation = new Div();
        navigation.addClassName("navigation");
        navigation.setWidth("23%");
        Div contentArea = new Div();

        Button addDiv = new Button("Add div to content area");
        addDiv.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_LARGE);
        addDiv.getStyle().setBackgroundColor("hsla(214, 35%, 15%, .85)");

        Button removeLastDiv = new Button("Remove last");
        removeLastDiv.addClassName("button-remove-div");
        removeLastDiv.setEnabled(false);

        Button removeFirstDiv = new Button("Remove first");
        removeFirstDiv.addClassName("button-remove-div");
        removeFirstDiv.setEnabled(false);

        VerticalLayout buttons = new VerticalLayout();
        buttons.setSpacing(false);
        buttons.setPadding(false);
        buttons.add(removeFirstDiv, removeLastDiv);

        removeLastDiv.addClickListener(event -> {
            var children = contentArea.getChildren().count();
            // remove the last div

            if (children > 0) {
                contentArea.remove(contentArea.getChildren().skip(children - 1).findFirst().get());
                removeFirstDiv.setEnabled(true);
                removeLastDiv.setEnabled(true);
            } else {
                removeLastDiv.setEnabled(false);
                removeFirstDiv.setEnabled(false);
                Notification.show("No more divs to remove");
            }
        });

        removeFirstDiv.addClickListener(event -> {
            var children = contentArea.getChildren().count();
            // remove the first div

            if (children > 0) {
                contentArea.remove(contentArea.getChildren().findFirst().get());
                removeFirstDiv.setEnabled(true);
                removeLastDiv.setEnabled(true);
            } else {
                removeLastDiv.setEnabled(false);
                removeFirstDiv.setEnabled(false);
                Notification.show("No more divs to remove");
            }
        });

        addDiv.addClickListener(event -> {
            Div div = new Div();
            div.addClassName("content-div");
            int children = (int) (contentArea.getChildren().count() + 1);
            div.setText("Div " + children);
            div.setWidth("110px");
            div.setHeight("110px");
            contentArea.add(div);
            removeLastDiv.setEnabled(true);
            removeFirstDiv.setEnabled(true);
        });
        navigation.add(addDiv, buttons);

        contentArea.setWidth("77%");
        contentArea.addClassName("content-area");
//        contentArea.getStyle().set("flex-grow", "1");

        HorizontalLayout content = new HorizontalLayout();
        content.addClassName("content");
        content.add(navigation, contentArea);
        content.setWidth("100%");
        content.setHeight("60%");
        content.setSpacing(false);
        content.getStyle().set("flex-grow", "1");

        Div footer = new Div();
        footer.addClassName("footer");
        footer.setText("This is the footer");
        footer.setHeight("100px");
        footer.setWidth("100%");
        footer.getStyle().set("flex-shrink", "0");

        add(header, content, footer);
    }
}
