package com.project.zulassungssystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class ZulassungsController {

	private final UserRepository userRepository;

	@Autowired
	public ZulassungsController(UserRepository ur) {
		this.userRepository = ur;
	}

	@GetMapping("/zulassung")
	public String dataTable(Model model) {
		List<UserBewerberModel> students = new ArrayList<UserBewerberModel>();
		// students.add(new User("Jack", "Bauer", "test@test.de", Roles.BEWERBER));

		for (User user : userRepository.findAll()) {
			if (user.getRole().equals("ROLE_BEWERBER")) {
				students.add(new UserBewerberModel(user.getFirstName(), user.getLastName(), user.getEmail(),
						user.getBewerber().getStatus(), user.getBewerber().getContent()));
			}
		}

		// logic to build student data
		model.addAttribute("students", students);
		return "zulassung";
	}

	@GetMapping("/changestatus")
	public String getForm(Model model) {
		model.addAttribute("cstatusmodel", new ChangeStatusModel());
		return "changestatus";
	}

	@PostMapping("/changestatus")
	public String submitForm(@ModelAttribute ChangeStatusModel cStatusModel, Model model) {
		model.addAttribute("cstatusmodel", cStatusModel);

		User user = userRepository.findById(cStatusModel.getId());

		if (cStatusModel.getContent().equals("Zugelassen")) {
			System.out.println("Bewerbers mit der Id:" + cStatusModel.getId() + " wird zugelassen.");
			user.getBewerber().setStatus(Status.ZUGELASSEN);
			userRepository.save(user);
		}

		return "changestatusresult";
	}

}