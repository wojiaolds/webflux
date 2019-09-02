package com.lds.example.handler;

import com.lds.example.bean.User;
import com.lds.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 相当于controller
 * @Author: lds
 * @Date: 2019/9/2 17:10
 */
@Component
@Slf4j
public class UserHandler {
	@Autowired
	UserService userService;
	
	
	public Mono<ServerResponse> getUserList( ServerRequest request) { //Lambda 匿名参数
		
		Flux<User> userFlux = userService.findUserList();
		userFlux.subscribe(user -> log.info(user.toString()));
		return ServerResponse.ok().body(userFlux,User.class);
	}
	
	public Mono<ServerResponse> getUser(ServerRequest request) {
		
		String userId = request.pathVariable("userId");
		Mono<User> userMono = userService.findUserById(userId);
		userMono.subscribe(user -> log.info(user.toString()));
		return ServerResponse.ok().body(userMono,User.class);
	}
}

