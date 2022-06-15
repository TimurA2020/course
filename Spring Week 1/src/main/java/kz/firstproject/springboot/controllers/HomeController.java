package kz.firstproject.springboot.controllers;

import kz.firstproject.springboot.db.DBManager;
import kz.firstproject.springboot.db.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    // doGet() + @WebServlet(Value =///)
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Item> items = DBManager.getAllItems();
        model.addAttribute("items", items);
        return "indexpage"; // = req.getreqdispat ---- ("index.html).forward(req,resp)
    }

    @GetMapping(value = "/about")
    public String aboutpage(){
        return "about";
    }

    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "name") String name, @RequestParam(name = "price") double price,
                          @RequestParam(name = "number") int number){
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);

        DBManager.addItem(item);

        return "redirect:/"; //resp.sendRedirect("/");

    }
}
