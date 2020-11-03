package br.com.cliente.ClienteTCP.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cliente.ClienteTCP.dto.TextMessage;
import br.com.cliente.ClienteTCP.dto.User;
import br.com.cliente.ClienteTCP.service.MessageService;


@RestController
@RequestMapping(path = "/api/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@PostMapping(path = "/postmessage/")
	public ResponseEntity<byte[]> postMessage(@RequestBody TextMessage message){
		System.out.println("Request - " + message.toString());
 		byte[] responce = messageService.saveTextMessage(message);
 		System.out.println("Responce -" + new String(responce));
		return ResponseEntity.ok().body(responce);
	}
	
	@PostMapping(path = "/postuser/")
	public ResponseEntity<byte[]> postMessage(@RequestBody User user){
		System.out.println("Request - " + user.toString());
 		byte[] responce = messageService.saveUser(user);
 		System.out.println("Responce -" + new String(responce));
		return ResponseEntity.ok().body(responce);
	}
	
	@PostMapping(path = "/requestTime/")
	public ResponseEntity<Long> requestTime(@RequestBody TextMessage message){
		System.out.println("Request - " + message.toString());
 		Date responce = messageService.getTime(message);
 		System.out.println("Responce -" + responce.toString());
		return ResponseEntity.ok().body(responce.getTime());
	}
}
