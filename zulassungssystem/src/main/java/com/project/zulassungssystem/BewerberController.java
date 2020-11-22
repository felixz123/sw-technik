package com.project.zulassungssystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BewerberController {

    private final UserRepository userRepository;

    @Autowired
    public BewerberController(UserRepository ur) {
        this.userRepository = ur;
    }

    @GetMapping("/bewerber")
	public String greetingForm(Model model) {
        model.addAttribute("bewerber", new UserBewerberModel());

		return "bewerber";
	}

	@PostMapping("/bewerber")
	public String greetingSubmit(@ModelAttribute UserBewerberModel userBewerberModel, @AuthenticationPrincipal User user, Model model) {
		model.addAttribute("bewerber", userBewerberModel);

        user.getBewerber().setContent(userBewerberModel.getContent());
        user.getBewerber().setAbschluss(userBewerberModel.getAbschluss());
        user.getBewerber().setDurchschnitt(userBewerberModel.getDurchschnitt());

        userRepository.save(user);

		return "bewerber";
	}

}
