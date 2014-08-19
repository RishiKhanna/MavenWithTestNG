package com.generic.driverinit;

public class Grid {

	private String portNumber;
	private String gridAddress;

	public Grid(String gridAddress,String portNumber) {
		this.portNumber = portNumber;
		this.gridAddress = gridAddress;
	}
	
	public String getPortNumber() {
		return portNumber;
	}

	public String getGridAddress() {
		return gridAddress;
	}
}
