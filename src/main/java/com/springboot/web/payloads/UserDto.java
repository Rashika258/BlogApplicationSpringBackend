package com.springboot.web.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4, message="User Name should be min of 4 characters")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=4, max=10, message="Password should be min 4 characters and maximum of 10 characters")
	private String password;
	
	@NotNull
	private String about;
	
}
