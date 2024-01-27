package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class ProductForm extends VerticalLayout {
    public ProductForm() {
        TextField name = new TextField();
        TextArea description = new TextArea();
        NumberField price = new NumberField(); // set step() and prefix
        // set step on price field
        price.setStep(0.01);
        // set prefix on price field
        price.setPrefixComponent(new Span("$"));
        ComboBox<String> category = new ComboBox<>();
        category.setItems("Category 1", "Category 2", "Category 3");
        // add buttons
        Button save = new Button("Save");
        save.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY);
        Button cancel = new Button("Cancel");
        // add fields and buttons
        DatePicker datePicker = new DatePicker();
        add(name, description, price, category, save, cancel, datePicker);

    }
}
