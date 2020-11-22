package com.project.zulassungssystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ZulassungsController {

	private final UserRepository userRepository;

	@Autowired
    public ZulassungsController(UserRepository ur) {
        this.userRepository = ur;
    }

	@GetMapping("/datatable")
	public String dataTable(Model model) {
		List<User> students = new ArrayList<User>();
		// students.add(new User("Jack", "Bauer", "test@test.de", Roles.BEWERBER));

		for (User user : userRepository.findAll()) {
			if(user.getRole() == Roles.BEWERBER) {
				students.add(user);
			}
		}
		
		// logic to build student data
		model.addAttribute("students", students);
		return "datatable";
	}

}