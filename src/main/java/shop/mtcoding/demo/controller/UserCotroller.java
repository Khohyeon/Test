package shop.mtcoding.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.demo.model.User;
import shop.mtcoding.demo.model.UserRepository;

@Controller
public class UserCotroller {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result == 1) {
            return "redirect:/loginForm";
        } else {
            return "redirect:/joinForm";
        }
    }

    @GetMapping("/loginForm")
    public String loingForm(HttpServletRequest request) {
        String username = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("remember")) {
                username = cookie.getValue();
            }
        }
        request.setAttribute("remember", username);
        return "/user/loginForm";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return "redirect:/loginForm";
        } else {
            session.setAttribute("principal", user);
            return "redirect:/list";
        }

    }

    @GetMapping("/updateForm")
    public String updateForm(Model model) {
        User sessionId = (User) session.getAttribute("principal");
        if (sessionId == null) {
            return "redirect:/loginForm";
        }
        User user = userRepository.findOne(sessionId.getId());
        model.addAttribute("user", user);
        return "user/updateForm";
    }

    @PostMapping("/update")
    public String update(String username, String password, String email) {
        User sessionId = (User) session.getAttribute("principal");
        if (sessionId == null) {
            return "redirect:/loginForm";
        }
        int result = userRepository.updateByUsernamePasswordEmail(sessionId.getId(), username, password, email);
        if (result == 1) {
            return "redirect:/listForm";
        } else {
            return "redirect:/user/updateForm";
        }
    }

}
