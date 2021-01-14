/**
 * 
 */
package cmet.ac.server.components;

/**
 * @author Jay
 *
 */
public abstract class AbstractServerComponent {
	// Common elements for any server that you are going to implement - room to be expanded by you
	public abstract void handleMessagesFromClient(String msg, ClientManager client);
	public abstract void sendMessageToClient(String msg, ClientManager client);
}
