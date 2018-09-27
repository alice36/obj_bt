package pl.javastart.springdata.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.springdata.model.Voucher;
import pl.javastart.springdata.repository.TicketRepository;
import pl.javastart.springdata.repository.VoucherRepository;
import pl.javastart.springdata.model.Ticket;

import java.util.List;

public class TicketController {
    TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;

    }

    @GetMapping("/tAdding")
    public String home(Model model) {
        Ticket ticket = new Ticket();
        String username = System.getProperty("user.name");
        ticket.setLogin(username);
        model.addAttribute("newTicket", ticket);
        return "tAdd";
    }

    @GetMapping("/tshow")
    public String home2(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "ticketshow";
    }

    @PostMapping("/generated")
    public String ticketiing(Ticket ticket, Model model) {
        ticketRepository.save(ticket);

        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "redirect:/ticketshow";
    }
}
