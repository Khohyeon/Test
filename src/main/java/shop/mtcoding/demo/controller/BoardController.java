package shop.mtcoding.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.demo.model.Board;
import shop.mtcoding.demo.model.BoardRepository;
import shop.mtcoding.demo.model.User;

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

}
