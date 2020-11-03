package br.com.cliente.ClienteTCP.dto;

public class TextMessage {
	private String message;
	private Integer polynomial;
	private String ip;
	private Integer port;
	
	public TextMessage(String message, Integer polynomial, String ip, Integer port) {
		super();
		this.message = message;
		this.polynomial = polynomial;
		this.ip = ip;
		this.port = port;
	}
	
	public TextMessage() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getPolynomial() {
		return polynomial;
	}

	public void setPolynomial(Integer polynomial) {
		this.polynomial = polynomial;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return this.port;
	}

	@Override
	public String toString() {
		return "TextMessage [message=" + message + ", polynomial=" + polynomial + ", ip=" + ip + ", port=" + port + "]";
	}
}
