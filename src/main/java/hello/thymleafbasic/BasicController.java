package hello.thymleafbasic;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("text-basic")
    public String basic(Model model) {
        model.addAttribute("data", "Hello Thymeleaf!");

        return "basic/text-basic";
    }

    @GetMapping("text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Thymeleaf!</b>");

        return "basic/text-unescaped";
    }

    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        //List로 대상을 넣기
        ArrayList<User> list = new ArrayList<>();

        list.add(userA);
        list.add(userB);

        HashMap<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap",map);

        return "basic/variable";

    }


    @GetMapping("/basic-objects")
    public String basicObjects(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.setAttribute("sessionData", "Hello Thymeleaf!");
        model.addAttribute("request", request);
        model.addAttribute("response", response);
        model.addAttribute("servletContext", request.getServletContext());

        return "basic/basic-objects";

    }


    @Component("helloBean")
    public class HelloBean {
        public String hello(String data) {
            return "Hello " + data;
        }
    }



    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";

    }


    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");

        return "basic/link";
    }


    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!");

        return "basic/literal";
    }


    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring!");

        return "basic/operation";
    }


    @GetMapping("/attribute")
    public String attribute(Model model) {
        return "basic/attribute";
    }

    @GetMapping("/each")
    public String each(Model model) {
        addUser(model);
        return "basic/each";
    }

    @GetMapping("/condition")
    public String condition(Model model) {
        addUser(model);
        return "basic/condition";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data", "spring!");
        return "basic/comments";
    }

    @GetMapping("/block")
    public String block(Model model) {
        addUser(model);
        return "basic/block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User("user\"A\"", 10));
        addUser(model);

        return "basic/javascript";
    }


    private void addUser(Model model) {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("userA", 10));
        users.add(new User("userB", 20));
        users.add(new User("userC", 30));

        model.addAttribute("users", users);
    }

    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }


}
