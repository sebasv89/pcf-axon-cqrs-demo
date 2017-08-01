package io.pivotal.catalog.events;

/**
 * Created by benwilcock on 18/04/2017.
 */
public class ProductEditedEvent {

    private String id;
    private String name;

    public ProductEditedEvent() {
    }

    public ProductEditedEvent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
