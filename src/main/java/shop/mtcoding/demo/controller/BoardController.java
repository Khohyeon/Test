package shop.mtcoding.demo.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.demo.model.Board;
import shop.mtcoding.demo.model.BoardRepository;
import shop.mtcoding.demo.model.User;
import shop.mtcoding.demo.model.UserRepository;

@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/listForm")
    public String listForm(Model model) {
        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    @GetMapping("/list")
    public String list() {
        User sessionId = (User) session.getAttribute("principal");
        if (sessionId == null) {
            return "redirect:/notfound";
        }
        Board board = boardRepository.findList(sessionId.getId());
        if (board == null) {
            return "redirect:/notfound";
        } else {
            return "redirect:/listForm";
        }
        // System.out.println("디버그" + board);
    }

    @GetMapping("/updateForm")
    public String update() {
        return "board/updateForm";
    }

}
