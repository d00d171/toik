package pl.edu.agh.lab.toik.comm;

public class Message {

	private MessageType type;

	private Object value;

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
