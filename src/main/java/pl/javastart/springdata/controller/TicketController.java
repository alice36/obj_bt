package pl.javastart.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.springdata.repository.TicketRepository;
import pl.javastart.springdata.model.Ticket;

import java.util.List;

@Controller
public class TicketController {
    TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;

    }

    @GetMapping("/tshow")
    public String home2(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tshow";
    }

    @PostMapping("/generated")
    public String ticketiing(Ticket ticket, Model model) {
        ticketRepository.save(ticket);

        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "redirect:/tshow";
    }
}
