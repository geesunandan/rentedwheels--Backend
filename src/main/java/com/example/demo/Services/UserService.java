package com.example.demo.Services;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Gives users list
	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<User> newUserList = new ArrayList<>();
		for (User user : userList) {
			if (!user.isDeleted()) {
				newUserList.add(user);
			}
		}
		return newUserList;
		// return userRepository.findAll().stream().filter(x ->
		// !x.isDeleted()).collect(Collectors.toList());
	}

	// Gives admin list
	public List<User> getAllAdmin() {
		List<User> adminList = userRepository.findAll();
		List<User> newAdminList = new ArrayList<>();
		for (User user : adminList) {
			if (user.isAdmin()) {
				newAdminList.add(user);
			}
		}
		return newAdminList;

	}

	// Finding the user
	public User getById(int id) {
		return (User) userRepository.findById(id).orElse(null);
	}

	//Update the user
	public User updateUser(User user) {
		User user1 = userRepository.findById(user.getId()).get();

		user1.setAddress(user.getAddress());
		user1.setCitizenshipAttachment(user.getCitizenshipAttachment());
		user1.setFullName(user.getFullName());
		user1.setEmailAddress(user.getEmailAddress());
		user1.setPassword(user.getPassword());
		user1.setPickupOutlet(user.getPickupOutlet());
		user1.setPhoneNumber(user.getPhoneNumber());
		return userRepository.save(user1);
	}

	// Deletes the user

	public User deleteUser(int id) {
		User user = userRepository.findById(id).get();
		user.setDeleted(true);
		return userRepository.save(user);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		System.out.println(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found In the Database");
		} else {
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
