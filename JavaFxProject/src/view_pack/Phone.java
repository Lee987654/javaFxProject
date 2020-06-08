package view_pack;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private SimpleStringProperty smartPhone;
	private SimpleStringProperty image;

	Phone(String smartPhone, String image) {
		this.smartPhone = new SimpleStringProperty(smartPhone);
		this.image = new SimpleStringProperty(image);
	
	
	
	
	
	}
	
	public void setImage(String image) {
		this.image.set(smartPhone);
	}
	public String getSmartPhone() {
		return this.image.get();
	}
	public SimpleStringProperty smartPhoneProperty() {
		return this.image;
	}


}