package org.vaadin.example.org.vaadin.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LayoutVertical extends VerticalLayout {
    public LayoutVertical() {
        VerticalLayout layout = new VerticalLayout();
        layout.add(new Button("Button 1"));
        layout.add(new DatePicker());
        layout.add(new ComboBox<>());
        add(layout);
    }
}
