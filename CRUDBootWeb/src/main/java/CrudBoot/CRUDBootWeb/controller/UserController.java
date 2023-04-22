package CrudBoot.CRUDBootWeb.controller;

import CrudBoot.CRUDBootWeb.Service.UserService;
import CrudBoot.CRUDBootWeb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //показать всех _______________________________________________________________________________
    @GetMapping("/allUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    //создать нового _______________________________________________________________________________
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
    return "newUser";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:users/allUsers";
    }

    //прочитать по id _______________________________________________________________________________
    @GetMapping("/{id}")
    public String read(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.readUser(id));
        return "show";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.readUser(id));
        return "updateUser";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(user,id);
        return "redirect:users/allUsers";
    }

    @DeleteMapping("/{id}")
    public String  deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users/allUsers";
    }
}
