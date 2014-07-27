package org.testng.driverinit;

public class Grid {

	public String portNumber;
	public String gridAddress;

	public Grid() {
		portNumber = "4444";
		gridAddress = "localhost";
	}

	public Grid(String portNumber,String gridAddress) {
		this.portNumber = portNumber;
		this.gridAddress = gridAddress;
	}
}
