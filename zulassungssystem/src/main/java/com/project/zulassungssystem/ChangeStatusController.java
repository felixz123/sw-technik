package com.project.zulassungssystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChangeStatusController {

    private final UserRepository userRepository;

	@Autowired
    public ChangeStatusController(UserRepository ur) {
        this.userRepository = ur;
    }

    @GetMapping("/changestatus")
        public String greetingForm(Model model) {
        model.addAttribute("changestatus", new ChangeStatusModel());
        return "changestatus";
    }

    @PostMapping("/changestatus")
    public String greetingSubmit(@ModelAttribute ChangeStatusModel cStatusModel, Model model) {
        model.addAttribute("changestatus", cStatusModel);

        User user = userRepository.findById(cStatusModel.getId());

        if(cStatusModel.getContent().equals("Zugelassen")) {
            System.out.println("Bewerbers mit der Id:" + cStatusModel.getId() + " wird zugelassen.");
            user.getBewerber().setStatus(Status.ZUGELASSEN);
            userRepository.save(user);
        }
        
        return "changestatusresult";
    }

}