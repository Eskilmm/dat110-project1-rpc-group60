package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCCommon;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;
import no.hvl.dat110.system.display.DisplayImpl;




public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		RPCServer rpcServer = new RPCServer(Common.DISPLAYPORT);
		
		DisplayImpl displayService = new DisplayImpl(RPCCommon.RPIDDISPLAY, rpcServer);
		
		
		rpcServer.register(RPCCommon.RPIDDISPLAY, displayService);
		
		rpcServer.run();
		
		
		
		
		
		
		System.out.println("Display server stopping ...");
		
		
	}
}
