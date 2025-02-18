package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;

import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		
		//marhsalle in til byte array
		
		byte[] requestParam = RPCUtils.marshallString(message);
		
		byte[] reply = rpcclient.call(RPCCommon.RPIDDISPLAY, requestParam);
		
		RPCUtils.unmarshallVoid(reply);
		
		
	}
}
