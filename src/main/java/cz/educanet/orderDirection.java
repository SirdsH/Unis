package cz.educanet;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class orderDirection {

    public orderDirection() {
    }

    public orderDirection(String name, int orderDirectionID) {
        this.name = name;
        this.orderDirectionID = orderDirectionID;
    }

    private String name;
    private int orderDirectionID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderDirectionID() {
        return orderDirectionID;
    }

    public void setOrderDirectionID(int orderDirectionID) {
        this.orderDirectionID = orderDirectionID;
    }
}
