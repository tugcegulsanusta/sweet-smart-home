package ui;

public class PanelLimitException extends Exception{
    public PanelLimitException(){
        super("Device Panels reached its limits!");
    }

}
