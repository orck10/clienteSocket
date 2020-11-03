package br.com.cliente.ClienteTCP.dto;

public class User {
	
	private Integer age;
	private Integer weight;
	private Float size;
	private String name;
	
	private Integer polynomial;
	private String ip;
	private Integer port;
	
	public User(Integer age, Integer weight, Float size, String name, Integer polynomial, String ip, Integer port) {
		super();
		this.age = age;
		this.weight = weight;
		this.size = size;
		this.name = name;
		this.polynomial = polynomial;
		this.ip = ip;
		this.port = port;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Float getSize() {
		return size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", weight=" + weight + ", size=" + size + ", name=" + name + ", polynomial="
				+ polynomial + ", ip=" + ip + ", port=" + port + "]";
	}
	
	
}

