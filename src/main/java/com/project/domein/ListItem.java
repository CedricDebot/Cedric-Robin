package com.project.domein;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Cédric
 */
public class ListItem
{
    private final StringProperty name = new SimpleStringProperty();

    private String getName()
    {
        return name.get();
    }

    private void setName(String value)
    {
        name.set(value);
    }

    private StringProperty nameProperty()
    {
        return name;
    }
    private final BooleanProperty selected = new SimpleBooleanProperty();

    private boolean isSelected()
    {
        return selected.get();
    }

    private void setSelected(boolean value)
    {
        selected.set(value);
    }

    private BooleanProperty selectedProperty()
    {
        return selected;
    }
    
    
}
