package com.jmaster.shopbanhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MySecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetails; // lay user tu database len
	
	//Authentication : xac thuc tai khoan
	//authorize : lam sau khi authentication thanh cong de phan quyen
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
//		auth.userDetailsService(userDetails).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// phân quyền
//		http.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/admin/**").hasAnyRole("ADMIN","SYSTEMADMIN").anyRequest().authenticated() // phai dang nhap
//		.antMatchers("/member/**").hasRole("MEMBER").anyRequest().permitAll()
//		
//		// cấu hình giao diện
//		.and().formLogin().loginPage("/login").loginProcessingUrl("/login")
//		.failureUrl("/login") // danh nhap sai ve sang login
//		.defaultSuccessUrl("/home", true) // dang nhap dung ve trang home
//		.and().logout().logoutSuccessUrl("/home");
		
		//khi ng dung truy cap trai phep
//		.and().exceptionHandling().accessDeniedPage("/access-deny");
		
		http.csrf().disable()
		.authorizeRequests().anyRequest().permitAll();
	}
	
	public static void main(String[] args) {
		String rawPass = "123456";
		String endcode = new BCryptPasswordEncoder().encode(rawPass);
		System.out.println(endcode);
		boolean check = new BCryptPasswordEncoder().matches(rawPass, endcode);
		System.out.println(check);
	}
}
