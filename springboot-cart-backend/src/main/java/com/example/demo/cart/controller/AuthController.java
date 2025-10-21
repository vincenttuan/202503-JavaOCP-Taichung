package com.example.demo.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.exception.LoginException;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.UserService;

import jakarta.servlet.http.HttpSession;

/**
 * AuthController:
 * Request Mapping: "/auth"
 * ---------------------------------------------------------------------------------------------------
 * POST "/login"      登入      範例: "/auth/login"
 * GET  "/logout"     登出      範例: "/auth/logout"
 * GET  "/isLoggedIn" 判斷登入狀態 範例: "/auth/isLoggedIn"
 * */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ApiResponse<UserDTO> login(@RequestBody LoginDTO loginDTO, HttpSession httpSession) {
		try {
			UserDTO userDTO = userService.login(loginDTO);
			// 登入成功:
			// 不要將密碼顯示出來
			userDTO.setPassword("******");
			// 將 userDTO 存放到 httpsession
			httpSession.setAttribute("userDTO", userDTO);
			return new ApiResponse<>(200, "登入成功", userDTO);
		} catch (LoginException e) {
			return new ApiResponse<>(401, e.getMessage(), null);
		} catch (Exception e) {
			return new ApiResponse<>(400, "其他錯誤:" + e.getMessage(), null);
		}
	}
	
	@GetMapping("/logout")
	public ApiResponse<Void> logout(HttpSession httpSession) {
		httpSession.invalidate();
		return new ApiResponse<>(200, "登出成功", null);
	}
	
	@GetMapping("/isLoggedIn")
	public ApiResponse<LoginDTO> isLoggedIn(HttpSession session) {
		LoginDTO loginDTO = new LoginDTO();
		
		if(session.getAttribute("userDTO") == null) {
			loginDTO.setIsLoggedIn(false);
			return new ApiResponse<>(400, "無登入資料", loginDTO);
		}
		
		UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
		loginDTO.setIsLoggedIn(true);
		loginDTO.setUsername(userDTO.getUsername());
		loginDTO.setPassword(userDTO.getPassword());
		return new ApiResponse<>(200, "仍在登入狀態", loginDTO);
	}
	
	
}
