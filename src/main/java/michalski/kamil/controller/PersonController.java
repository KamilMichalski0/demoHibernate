package michalski.kamil.controller;
import michalski.kamil.dao.PersonDao;
import michalski.kamil.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class PersonController {

    @Autowired
    PersonDao personDao;

    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("person", new Person());
        return "/add";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Person person, ModelMap modelMap) {
        modelMap.addAttribute("person", person);
        personDao.save(person);

        return "redirect:success";
    }

    @GetMapping("/success")
    public String success(ModelMap modelMap) {
        return "/success";
    }

    @GetMapping("/search")
    public String search(ModelMap modelMap) {
        modelMap.addAttribute("person", new Person());
        return "/search";
    }

    @PostMapping("/results")
    public String results(@ModelAttribute Person person, ModelMap modelMap) {
        List<Person> people = personDao.findBySurname(person.getSurname());
        modelMap.addAttribute("persons", people);
        return "/results";
    }

    @GetMapping("/all")
    public String listAll(ModelMap modelMap) {
        List<Person> people = personDao.getAll();
        modelMap.addAttribute("persons", people);
        return "/results";
    }
}
